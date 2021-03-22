package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.TopicLink;
import dev.carrico.repos.TopicLinkRepo;
import dev.carrico.services.TopicLinkServiceImpl;
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
public class TopicLinkServiceTests {
    
    @InjectMocks
    private TopicLinkServiceImpl topicLinkService;
    
    @Mock
    private TopicLinkRepo topicLinkRepo;
    
    @Test
    void create_topiclink(){
        Mockito.when(topicLinkRepo.save(any())).then(returnsFirstArg());

        TopicLink topicLink = new TopicLink();
        topicLink.setTopicLinkId(9);
        topicLink.setStackId(1);
        topicLink.setTopicId(1);
        topicLink = this.topicLinkService.createTopicLink(topicLink);

        Assertions.assertEquals(0, topicLink.getTopicLinkId());
    }
}
