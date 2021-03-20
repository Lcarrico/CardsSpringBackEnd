package dev.carrico.controllers;

import dev.carrico.entities.Tag;
import dev.carrico.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Component
@RestController
public class TagController {
    @Autowired
    TagService tagService;

    @PostMapping("/tags")
    @ResponseBody
    public Tag createTag(@RequestBody Tag tag){
        this.tagService.createTag(tag);
        return tag;
    }

    @GetMapping("/tags/{tagId}")
    @ResponseBody
    public Tag getTagById(@PathVariable int tagId){
        Tag tag = this.tagService.getTagById(tagId);
        return tag;
    }

    @GetMapping("/tags")
    @ResponseBody
    public Set<Tag> getTags(@RequestParam(name = "tagName",defaultValue = "") String tagName){
        Set<Tag> tags;
        if (tagName.isEmpty()){
            tags = this.tagService.getAllTags();
        }
        else {
            tags = new HashSet<>();
            tags.add(this.tagService.getTagByTagName(tagName));
        }
        return tags;
    }

    @PutMapping("/tags/{tagId}")
    @ResponseBody
    public Tag updateTag(@PathVariable int tagId, @RequestBody Tag tag){
        tag.setTagId(tagId);
        this.tagService.updateTag(tag);
        return tag;
    }

    @DeleteMapping("/tags/{tagId}")
    @ResponseBody
    public Boolean deleteTagById(@PathVariable int tagId){
        Boolean result = this.tagService.deleteTagById(tagId);
        return result;
    }
}
