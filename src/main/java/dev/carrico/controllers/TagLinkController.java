package dev.carrico.controllers;

import dev.carrico.entities.TagLink;
import dev.carrico.services.TagLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
public class TagLinkController {
    @Autowired
    TagLinkService tagLinkService;

    @PostMapping("/tagLinks")
    @ResponseBody
    public TagLink createTagLink(@RequestBody TagLink tagLink){
        this.tagLinkService.createTagLink(tagLink);
        return tagLink;
    }

    @GetMapping("/tagLinks/{tagLinkId}")
    @ResponseBody
    public TagLink getTagLinkById(@PathVariable int tagLinkId){
        TagLink tagLink = this.tagLinkService.getTagLinkById(tagLinkId);
        return tagLink;
    }

    @GetMapping("/tagLinks")
    @ResponseBody
    public Set<TagLink> getAllTagLinks(@RequestParam(name = "tagId", defaultValue = "") String tagId,
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
        return tagLinks;
    }

    @PutMapping("/tagLinks/{tagLinkId}")
    @ResponseBody
    public TagLink updateTagLink(@PathVariable int tagLinkId, @RequestBody TagLink tagLink){
        tagLink.setTagLinkId(tagLinkId);
        this.tagLinkService.updateTagLink(tagLink);
        return tagLink;
    }

    @DeleteMapping("/tagLinks/{tagLinkId}")
    @ResponseBody
    public Boolean deleteTagLinkById(@PathVariable int tagLinkId){
        Boolean result = this.tagLinkService.deleteTagLinkById(tagLinkId);
        return result;
    }

}
