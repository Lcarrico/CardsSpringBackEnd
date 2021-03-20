package dev.carrico.services;

import dev.carrico.entities.TopicLink;
import dev.carrico.repos.TopicLinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class TopicLinkServiceImpl implements TopicLinkService{
    @Autowired
    TopicLinkRepo topicLinkRepo;

    @Override
    public TopicLink createTopicLink(TopicLink topicLink) {
        topicLinkRepo.save(topicLink);
        return topicLink;
    }

    @Override
    public TopicLink getTopicLinkById(int topicLinkId) {
        TopicLink topicLink = topicLinkRepo.findById(topicLinkId).get();
        return topicLink;
    }

    @Override
    public Set<TopicLink> getTopicLinksByTopicId(int topicId) {
        Set<TopicLink> topicLinks = this.topicLinkRepo.findByTopicId(topicId);
        return topicLinks;
    }

    @Override
    public Set<TopicLink> getTopicLinksByStackId(int stackId) {
        Set<TopicLink> topicLinks = this.topicLinkRepo.findByStackId(stackId);
        return topicLinks;
    }

    @Override
    public Set<TopicLink> getAllTopicLinks() {
        Set<TopicLink> topicLinks = new HashSet<>();
        this.topicLinkRepo.findAll().forEach(topicLinks::add);
        return topicLinks;
    }

    @Override
    public TopicLink updateTopicLink(TopicLink topicLink) {
        this.topicLinkRepo.save(topicLink);
        return topicLink;
    }

    @Override
    public boolean deleteTopicLinkById(int topicLinkId) {
        this.topicLinkRepo.deleteById(topicLinkId);
        return true;
    }
}
