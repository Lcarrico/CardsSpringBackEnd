package dev.carrico.RepoTests;

import dev.carrico.entities.Tag;
import dev.carrico.repos.TagRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@Transactional
public class TagRepoTests {

    @Autowired
    TagRepo tagRepo;

    @Test
    void create_tag(){
        Tag tag = new Tag();
        tag.setTagName("Math");
        tagRepo.save(tag);
        Assertions.assertNotEquals(0, tag.getTagId());
    }

    @Test
    void get_all_tags(){
        Set<Tag> tags = new HashSet<>();
        this.tagRepo.findAll().forEach(tags::add);
        System.out.println(tags);
        Assertions.assertTrue(tags.size() > 0);
    }
}
