package dev.carrico.services;

import dev.carrico.entities.Topic;

import java.util.Set;

public interface TopicService {
    Topic createTopic(Topic topic);

    Topic getTopicById(int topicId);
    Set<Topic> getAllTopics();

    Topic updateTopic(Topic topic);

    boolean deleteTopicById(int topicId);

}
