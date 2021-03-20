package dev.carrico.repos;

import dev.carrico.entities.StackLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Component
@Repository
public interface StackLinkRepo extends CrudRepository<StackLink, Integer> {
    Set<StackLink> findByLearnerId(int learnerId);
    Set<StackLink> findByRelationship(String relationship);
}
