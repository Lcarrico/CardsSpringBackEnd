package dev.carrico.repos;

import dev.carrico.entities.Learner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface LearnerRepo extends CrudRepository<Learner, Integer> {

    Learner findByUsernameAndPassword(String username, String password);
}
