package dev.carrico.CardsSpringBackEnd.RepoTests;

import dev.carrico.entities.Topic;
import dev.carrico.repos.TopicRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@Transactional
public class TopicRepoTests {

    @Autowired
    private TopicRepo topicRepo;

    @Test
    void create_topic(){
        Topic topic = new Topic();
        topic.setTopicName("Math");
        this.topicRepo.save(topic);

        Assertions.assertNotEquals(0, topic.getTopicId());
    }

    @Test
    void get_topic_by_id(){
        Topic topic = this.topicRepo.findById(1).get();
        Assertions.assertNotNull(topic);
        Assertions.assertEquals(1, topic.getTopicId());
    }

    @Test
    void get_all_topics(){
        Set<Topic> topics = new HashSet<>();
        this.topicRepo.findAll().forEach(topics::add);
        System.out.println(topics);

        Assertions.assertTrue(topics.size() > 0);
    }

    @Test
    void get_topic_by_name(){
        Topic topic = this.topicRepo.findByTopicName("Math");

        Assertions.assertNotNull(topic);
        Assertions.assertTrue(topic.getTopicName().equals("Math"));
    }

    @Test
    void update_topic(){
        Topic topic = this.topicRepo.findById(1).get();
        topic.setTopicName("Science");
        this.topicRepo.save(topic);
        topic = this.topicRepo.findById(1).get();

        Assertions.assertTrue(topic.getTopicName().equals("Science"));
    }

    @Test
    void delete_topic(){
        Topic topic = this.topicRepo.findById(1).get();
        this.topicRepo.delete(topic);

        Assertions.assertNull(this.topicRepo.findById(1));
    }

    @Test
    void delete_topic_by_id(){
        this.topicRepo.deleteById(1);

        Assertions.assertNull(this.topicRepo.findById(1));
    }
}
