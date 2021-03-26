package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.Tag;
import dev.carrico.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
@RestController
@CrossOrigin
public class TagController {
    @Autowired
    TagService tagService;

    @PostMapping("/tags")
    @Authorized
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        this.tagService.createTag(tag);
        return ResponseEntity.status(200).body(tag);
    }

    @GetMapping("/tags/{tagId}")
    public ResponseEntity<Tag> getTagById(@PathVariable int tagId){
        Tag tag = this.tagService.getTagById(tagId);
        return ResponseEntity.status(200).body(tag);
    }

    @GetMapping("/tags")
    public ResponseEntity<Set<Tag>> getTags(@RequestParam(name = "tagName",defaultValue = "") String tagName){
        Set<Tag> tags;
        if (tagName.isEmpty()){
            tags = this.tagService.getAllTags();
        }
        else {
            tags = new HashSet<>();
            tags.add(this.tagService.getTagByTagName(tagName));
        }
        return ResponseEntity.status(200).body(tags);
    }

    @PutMapping("/tags/{tagId}")
    @Authorized
    public ResponseEntity<Tag> updateTag(@PathVariable int tagId, @RequestBody Tag tag){
        tag.setTagId(tagId);
        if (this.tagService.getTagById(tagId) == null){
            throw new NoSuchElementException("Unable to update. This tag does not exist.");
        }
        this.tagService.updateTag(tag);
        return ResponseEntity.status(200).body(tag);
    }

    @DeleteMapping("/tags/{tagId}")
    @Authorized
    public ResponseEntity<Boolean> deleteTagById(@PathVariable int tagId){
        Boolean result = this.tagService.deleteTagById(tagId);
        return ResponseEntity.status(200).body(result);
    }
}
