package dev.carrico.services;

import dev.carrico.entities.TopicLink;

import java.util.Set;

public interface TopicLinkService {
    TopicLink createTopicLink(TopicLink topicLink);

    TopicLink getTopicLinkById(int topicLinkId);
    Set<TopicLink> getTopicLinksByTopicId(int topicId);
    Set<TopicLink> getTopicLinksByStackId(int stackId);
    Set<TopicLink> getAllTopicLinks();

    TopicLink updateTopicLink(TopicLink topicLink);

    boolean deleteTopicLinkById(int topicLinkId);
}
