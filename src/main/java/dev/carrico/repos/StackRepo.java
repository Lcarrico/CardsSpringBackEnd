package dev.carrico.repos;

import dev.carrico.entities.Stack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface StackRepo extends CrudRepository<Stack, Integer> {

}
