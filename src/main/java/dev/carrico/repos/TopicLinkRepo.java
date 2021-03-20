package dev.carrico.repos;

import dev.carrico.entities.TopicLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Component
@Repository
public interface TopicLinkRepo extends CrudRepository<TopicLink, Integer> {
    Set<TopicLink> findByTopicId(int topicId);
    Set<TopicLink> findByStackId(int stackId);
}
