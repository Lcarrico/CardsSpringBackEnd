package dev.carrico.controllers;

import dev.carrico.entities.Tag;
import dev.carrico.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
public class TagController {
    @Autowired
    TagService tagService;

    @PostMapping("/tags")
    public Tag createTag(@RequestBody Tag tag){
        this.tagService.createTag(tag);
        return tag;
    }

    @GetMapping("/tags/{tagId}")
    public Tag getTagById(@PathVariable int tagId){
        Tag tag = this.tagService.getTagById(tagId);
        return tag;
    }

    @GetMapping("/tags")
    public Set<Tag> getAllTags(){
        Set<Tag> tags = this.tagService.getAllTags();
        return tags;
    }

    @PutMapping("/tags/{tagId}")
    public Tag updateTag(@PathVariable int tagId, @RequestBody Tag tag){
        tag.setTagId(tagId);
        this.tagService.updateTag(tag);
        return tag;
    }

    @DeleteMapping("/tags/{tagId}")
    public Boolean deleteBookById(@PathVariable int tagId){
        Boolean result = this.tagService.deleteTagById(tagId);
        return result;
    }
}
