package dev.carrico.repos;

import dev.carrico.entities.TopicLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface TopicLinkRepo extends CrudRepository<TopicLink, Integer> {
}
