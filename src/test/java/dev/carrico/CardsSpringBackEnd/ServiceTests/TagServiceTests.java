package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Tag;
import dev.carrico.repos.TagRepo;
import dev.carrico.services.TagServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TagServiceTests {

    @InjectMocks
    private TagServiceImpl tagService;

    @Mock
    private TagRepo tagRepo;

    @Test
    void create_tag(){
        Mockito.when(tagRepo.save(any())).then(returnsFirstArg());

        Tag tag = new Tag();
        tag.setTagId(9);
        tag.setTagName("Test");
        tag = this.tagService.createTag(tag);

        Assertions.assertEquals(0, tag.getTagId());
    }
}