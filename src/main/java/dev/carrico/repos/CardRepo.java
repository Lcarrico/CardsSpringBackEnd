package dev.carrico.repos;

import dev.carrico.entities.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CardRepo extends CrudRepository<Card, Integer> {


}
