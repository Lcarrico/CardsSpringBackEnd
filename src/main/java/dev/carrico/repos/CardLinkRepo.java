package dev.carrico.repos;

import dev.carrico.entities.CardLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Component
@Repository
public interface CardLinkRepo extends CrudRepository<CardLink, Integer> {
    Set<CardLink> findByCardId(int cardId);
    Set<CardLink> findByStackId(int stackId);

}
