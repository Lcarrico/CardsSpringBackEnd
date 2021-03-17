package dev.carrico.services;

import dev.carrico.entities.Tag;

import java.util.Set;

public interface TagService{

    Tag createTag(Tag tag);

    Tag getTagById(int tagId);
    Set<Tag> getAllTags();

    Tag updateTag(Tag tag);

    boolean deleteTagById(int tagId);


}