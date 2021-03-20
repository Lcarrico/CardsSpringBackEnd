package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Tag;
import dev.carrico.services.TagService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@SpringBootTest
@Transactional
public class TagServiceTests {
    @Autowired
    TagService ts;

    @Test
    void create_tag(){
        Tag tag = new Tag();
        tag.setTagName("Test");
        ts.createTag(tag);

        Assertions.assertNotEquals(0, tag.getTagId());
    }

    @Test
    void get_tag_by_id(){
        Tag tag = ts.getTagById(7);

        Assertions.assertNotNull(tag);
        Assertions.assertTrue(tag.getTagName().equals("Math"));
    }

    @Test
    void get_all_tag(){
        Set<Tag> tags = ts.getAllTags();

        Assertions.assertNotNull(tags);
        Assertions.assertTrue(tags.size() > 0);
    }

    @Test
    void update_tag(){
        Tag tag = new Tag();
        tag.setTagId(7);
        tag.setTagName("Not Math");
        ts.updateTag(tag);
        tag = ts.getTagById(7);

        Assertions.assertTrue(tag.getTagName().equals("Not Math"));
    }

    @Test
    void delete_tag(){
        boolean result = ts.deleteTagById(7);

        Assertions.assertTrue(result);
    }
}