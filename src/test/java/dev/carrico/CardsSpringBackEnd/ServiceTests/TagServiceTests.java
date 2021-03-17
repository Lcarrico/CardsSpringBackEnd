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
    void create_stack(){
        Tag tag = new Tag();
        tag.setTagName("Test");
        ts.createTag(tag);

        Assertions.assertNotEquals(0, tag.getTagId());
    }

    @Test
    void get_stack_by_id(){
        Tag tag = ts.getTagById(1);

        Assertions.assertNotNull(tag);
        Assertions.assertTrue(tag.getTagName().equals("Math"));
    }

    @Test
    void get_all_stacks(){
        Set<Tag> tags = ts.getAllTags();

        Assertions.assertNotNull(tags);
        Assertions.assertTrue(tags.size() > 0);
    }

    @Test
    void update_stack(){
        Tag tag = new Tag();
        tag.setTagId(1);
        tag.setTagName("Not Math");
        ts.updateTag(tag);
        tag = ts.getTagById(1);

        Assertions.assertTrue(tag.getTagName().equals("Not Math"));
    }

    @Test
    void delete_stack(){
        boolean result = ts.deleteTagById(1);

        Assertions.assertTrue(result);
    }
}