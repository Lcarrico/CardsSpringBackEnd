package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.TagLink;
import dev.carrico.repos.TagLinkRepo;
import dev.carrico.services.TagLinkServiceImpl;
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
public class TagLinkServiceTests {
    
    @InjectMocks
    private TagLinkServiceImpl tagLinkService;
    
    @Mock
    private TagLinkRepo tagLinkRepo;
    
    @Test
    void create_taglink(){
        Mockito.when(tagLinkRepo.save(any())).then(returnsFirstArg());

        TagLink tagLink = new TagLink();
        tagLink.setTagLinkId(9);
        tagLink.setCardId(1);
        tagLink.setTagId(1);
        tagLink = this.tagLinkService.createTagLink(tagLink);

        Assertions.assertEquals(0, tagLink.getTagLinkId());
    }
}
