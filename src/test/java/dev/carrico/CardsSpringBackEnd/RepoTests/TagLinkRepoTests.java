package dev.carrico.CardsSpringBackEnd.RepoTests;

import dev.carrico.entities.TagLink;
import dev.carrico.repos.TagLinkRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@Transactional
public class TagLinkRepoTests {

    @Autowired
    TagLinkRepo tagLinkRepo;

    @Test
    void create_tag_link(){
        TagLink tagLink = new TagLink();
        tagLink.setTagId(1);
        tagLink.setCardId(1);
        this.tagLinkRepo.save(tagLink);
        System.out.println(tagLink);

        Assertions.assertNotEquals(0, tagLink.getTagLinkId());
    }

    @Test
    void get_all_tag_links(){
        Set<TagLink> taglinks = new HashSet<>();
        this.tagLinkRepo.findAll().forEach(taglinks::add);
        System.out.println(taglinks);

        Assertions.assertTrue(taglinks.size() > 0);
    }

    @Test
    void get_tag_links_by_tag_id(){
        // TODO
    }

    @Test
    void get_tag_links_by_card_id(){
        // TODO
    }

    @Test
    void delete_tag_link(){
        TagLink tagLink = this.tagLinkRepo.findById(1).get();
        this.tagLinkRepo.delete(tagLink);

        Assertions.assertNull(this.tagLinkRepo.findById(1));
    }

    @Test
    void delete_tag_link_by_id(){
        this.tagLinkRepo.deleteById(1);

        Assertions.assertNull(this.tagLinkRepo.findById(1));
    }

}
