package dev.carrico.CardsSpringBackEnd.RepoTests;

import dev.carrico.entities.TopicLink;
import dev.carrico.repos.TopicLinkRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@Transactional
public class TopicLinkRepoTests {

    @Autowired
    private TopicLinkRepo topicLinkRepo;

    @Test
    void create_topic_link(){
        TopicLink topicLink = new TopicLink();
        topicLink.setTopicId(1);
        topicLink.setStackId(1);
        this.topicLinkRepo.save(topicLink);

        Assertions.assertNotEquals(0, topicLink.getTopicLinkId());
    }

    @Test
    void get_all_topic_links(){
        Set<TopicLink> topicLinks = new HashSet<>();
        this.topicLinkRepo.findAll().forEach(topicLinks::add);
        System.out.println(topicLinks);

        Assertions.assertTrue(topicLinks.size() > 0);
    }
    @Test
    void get_topic_link_by_id(){
        TopicLink topicLink = this.topicLinkRepo.findById(1).get();
        Assertions.assertNotNull(topicLink);
    }

    @Test
    void get_topic_links_by_stack_id(){
        Set<TopicLink> topicLinks = this.topicLinkRepo.findByStackId(1);
        Assertions.assertNotNull(topicLinks);
    }

    @Test
    void get_topic_links_by_topic_id(){
        Set<TopicLink> topicLinks = this.topicLinkRepo.findByTopicId(1);
        Assertions.assertNotNull(topicLinks);
    }

    @Test
    void delete_topic_link(){
        TopicLink topicLink = this.topicLinkRepo.findById(1).get();
        this.topicLinkRepo.delete(topicLink);

        Assertions.assertFalse(this.topicLinkRepo.findById(1).isPresent());
    }

    @Test
    void delete_topic_link_by_id(){
        this.topicLinkRepo.deleteById(1);

        Assertions.assertFalse(this.topicLinkRepo.findById(1).isPresent());
    }
}
