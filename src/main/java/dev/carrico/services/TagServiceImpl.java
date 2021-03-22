package dev.carrico.services;

import dev.carrico.entities.Tag;
import dev.carrico.repos.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class TagServiceImpl implements TagService{

    @Autowired
    TagRepo tagRepo;

    @Override
    public Tag createTag(Tag tag) {
        tag.setTagId(0);
        this.tagRepo.save(tag);
        return tag;
    }

    @Override
    public Tag getTagById(int tagId) {
        Tag tag = this.tagRepo.findById(tagId).get();
        return tag;
    }

    @Override
    public Tag getTagByTagName(String tagName) {
        Tag tag = this.tagRepo.findByTagName(tagName);
        return tag;
    }

    @Override
    public Set<Tag> getAllTags() {
        Set<Tag> tags = new HashSet<>();
        this.tagRepo.findAll().forEach(tags::add);
        return tags;
    }

    @Override
    public Tag updateTag(Tag tag) {
        this.tagRepo.save(tag);
        return tag;
    }

    @Override
    public boolean deleteTagById(int tagId) {
        this.tagRepo.deleteById(tagId);
        return true;
    }
}
