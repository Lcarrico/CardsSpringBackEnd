package dev.carrico.repos;

import dev.carrico.entities.CardStack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CardStackRepo extends CrudRepository<CardStack, Integer> {
}
