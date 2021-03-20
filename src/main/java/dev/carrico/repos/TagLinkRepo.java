package dev.carrico.repos;

import dev.carrico.entities.TagLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Component
@Repository
public interface TagLinkRepo extends CrudRepository<TagLink, Integer> {
    Set<TagLink> findByTagId(int tagId);
    Set<TagLink> findByCardId(int cardId);
}
