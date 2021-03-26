package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.TagLink;
import dev.carrico.services.CardService;
import dev.carrico.services.TagLinkService;
import dev.carrico.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Set;

@Component
@RestController
@CrossOrigin
public class TagLinkController {
    @Autowired
    TagLinkService tagLinkService;

    @Autowired
    TagService tagService;

    @Autowired
    CardService cardService;

    private void checkValidity(TagLink tagLink){
        Set<TagLink> tagLinks = this.tagLinkService.getTagLinksByTagId(tagLink.getTagId());
        for (TagLink tl: tagLinks){
            if (tl.getCardId() == tagLink.getCardId()){
                throw new DuplicateKeyException("TagLink already exists!");
            }
        }
        if (this.tagService.getTagById(tagLink.getTagId()) == null
                || this.cardService.getCardById(tagLink.getCardId()) == null){
            throw new NoSuchElementException("Tag or Card does not exist. Unable to create link.");
        }
    }

    @PostMapping("/tagLinks")
    @Authorized
    public ResponseEntity<TagLink> createTagLink(@RequestBody TagLink tagLink){
        this.checkValidity(tagLink);
        tagLink = this.tagLinkService.createTagLink(tagLink);
        return ResponseEntity.status(200).body(tagLink);
    }

    @GetMapping("/tagLinks/{tagLinkId}")
    public ResponseEntity<TagLink> getTagLinkById(@PathVariable int tagLinkId){
        TagLink tagLink = this.tagLinkService.getTagLinkById(tagLinkId);
        return ResponseEntity.status(200).body(tagLink);
    }

    @GetMapping("/tagLinks")
    public ResponseEntity<Set<TagLink>> getTagLinks(@RequestParam(name = "tagId", defaultValue = "") String tagId,
                                       @RequestParam(name = "cardId", defaultValue = "") String cardId){
        Set<TagLink> tagLinks = null;
        if (tagId.isEmpty() && cardId.isEmpty()){
            tagLinks = this.tagLinkService.getAllTagLinks();
        }
        else if (!tagId.isEmpty()){
            tagLinks = this.tagLinkService.getTagLinksByTagId(Integer.parseInt(tagId));
        }
        else if (!cardId.isEmpty()){
            tagLinks = this.tagLinkService.getTagLinksByCardId(Integer.parseInt(cardId));
        }
        return ResponseEntity.status(200).body(tagLinks);
    }

    @PutMapping("/tagLinks/{tagLinkId}")
    @Authorized
    public ResponseEntity<TagLink> updateTagLink(@PathVariable int tagLinkId, @RequestBody TagLink tagLink){
        tagLink.setTagLinkId(tagLinkId);
        this.checkValidity(tagLink);
        if (this.tagLinkService.getTagLinkById(tagLinkId) == null){
            throw new NoSuchElementException("Unable to update. This taglink does not exist.");
        }
        this.tagLinkService.updateTagLink(tagLink);
        return ResponseEntity.status(200).body(tagLink);
    }

    @DeleteMapping("/tagLinks/{tagLinkId}")
    @Authorized
    public ResponseEntity<Boolean> deleteTagLinkById(@PathVariable int tagLinkId){
        Boolean result = this.tagLinkService.deleteTagLinkById(tagLinkId);
        return ResponseEntity.status(200).body(result);
    }
}
