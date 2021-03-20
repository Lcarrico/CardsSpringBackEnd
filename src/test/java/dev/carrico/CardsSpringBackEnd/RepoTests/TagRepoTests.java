package dev.carrico.CardsSpringBackEnd.RepoTests;

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
        tag.setTagName("New Tag");
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

    @Test
    void get_tag_by_id(){
        Tag tag = this.tagRepo.findById(1).get();
        Assertions.assertEquals(1, tag.getTagId());
    }

    @Test
    void get_tag_by_tag_name(){
        Tag tag = this.tagRepo.findByTagName("Math");

        Assertions.assertNotNull(tag);
        Assertions.assertTrue(tag.getTagName().equals("Math"));
    }

    @Test
    void update_tag(){
        Tag tag = this.tagRepo.findById(1).get();
        tag.setTagName("Science");
        this.tagRepo.save(tag);
        tag = this.tagRepo.findById(1).get();

        Assertions.assertTrue(tag.getTagName().equals("Science"));
    }

    @Test
    void delete_tag(){
        Tag tag = this.tagRepo.findById(1).get();
        this.tagRepo.delete(tag);

        Assertions.assertFalse(this.tagRepo.findById(1).isPresent());
    }

    @Test
    void delete_tag_by_id(){
        this.tagRepo.deleteById(1);

        Assertions.assertFalse(this.tagRepo.findById(1).isPresent());
    }
}
