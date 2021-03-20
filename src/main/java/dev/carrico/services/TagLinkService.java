package dev.carrico.services;

import dev.carrico.entities.TagLink;

import java.util.Set;

public interface TagLinkService {
    TagLink createTagLink(TagLink tagLink);

    TagLink getTagLinkById(int tagLinkId);
    Set<TagLink> getTagLinksByTagId(int tagId);
    Set<TagLink> getTagLinksByCardId(int cardId);
    Set<TagLink> getAllTagLinks();

    TagLink updateTagLink(TagLink tagLink);

    boolean deleteTagLinkById(int tagLinkId);
}
