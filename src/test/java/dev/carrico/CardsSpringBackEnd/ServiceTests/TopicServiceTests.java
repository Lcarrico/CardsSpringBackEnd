package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Topic;
import dev.carrico.repos.TopicRepo;
import dev.carrico.services.TopicServiceImpl;
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
public class TopicServiceTests {

    @InjectMocks
    private TopicServiceImpl topicService;

    @Mock
    private TopicRepo topicRepo;

    @Test
    void create_topic(){
        Mockito.when(topicRepo.save(any())).then(returnsFirstArg());

        Topic topic = new Topic();
        topic.setTopicId(9);
        topic.setTopicName("Big maths");
        topic.setTopicId(1);
        topic = this.topicService.createTopic(topic);

        Assertions.assertEquals(0, topic.getTopicId());
    }
}
