package dev.carrico.services;

import dev.carrico.entities.Topic;
import dev.carrico.repos.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepo topicRepo;

    @Override
    public Topic createTopic(Topic topic) {
        this.topicRepo.save(topic);
        return topic;
    }

    @Override
    public Topic getTopicById(int topicId) {
        Topic topic = this.topicRepo.findById(topicId).get();
        return topic;
    }

    @Override
    public Set<Topic> getAllTopics() {
        Set<Topic> topics = new HashSet<>();
        this.topicRepo.findAll().forEach(topics::add);
        return topics;
    }

    @Override
    public Topic updateTopic(Topic topic) {
        this.topicRepo.save(topic);
        return topic;
    }

    @Override
    public boolean deleteTopicById(int topicId) {
        this.topicRepo.deleteById(topicId);
        return true;
    }
}
