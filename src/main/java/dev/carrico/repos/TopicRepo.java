package dev.carrico.repos;

import dev.carrico.entities.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface TopicRepo extends CrudRepository<Topic, Integer> {
    Topic findByTopicName(String topicName);
}
