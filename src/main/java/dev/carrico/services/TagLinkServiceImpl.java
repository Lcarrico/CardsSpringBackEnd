package dev.carrico.services;

import dev.carrico.entities.TagLink;
import dev.carrico.repos.TagLinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class TagLinkServiceImpl implements TagLinkService{
    @Autowired
    private TagLinkRepo tagLinkRepo;

    @Override
    public TagLink createTagLink(TagLink tagLink) {
        tagLinkRepo.save(tagLink);
        return tagLink;
    }

    @Override
    public TagLink getTagLinkById(int tagLinkId) {
        TagLink tagLink = this.tagLinkRepo.findById(tagLinkId).get();
        return tagLink;
    }

    @Override
    public Set<TagLink> getTagLinksByTagId(int tagId) {
        Set<TagLink> tagLinks = this.tagLinkRepo.findByTagId(tagId);
        return tagLinks;
    }

    @Override
    public Set<TagLink> getTagLinksByCardId(int cardId) {
        Set<TagLink> tagLinks = this.tagLinkRepo.findByCardId(cardId);
        return tagLinks;
    }

    @Override
    public Set<TagLink> getAllTagLinks() {
        Set<TagLink> tagLinks = new HashSet<>();
        this.tagLinkRepo.findAll().forEach(tagLinks::add);
        return tagLinks;
    }

    @Override
    public TagLink updateTagLink(TagLink tagLink) {
        this.tagLinkRepo.save(tagLink);
        return tagLink;
    }

    @Override
    public boolean deleteTagLinkById(int tagLinkId) {
        this.tagLinkRepo.deleteById(tagLinkId);
        return true;
    }
}
