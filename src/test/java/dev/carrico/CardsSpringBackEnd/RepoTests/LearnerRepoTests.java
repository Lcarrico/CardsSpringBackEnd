package dev.carrico.CardsSpringBackEnd.RepoTests;

import dev.carrico.entities.Learner;
import dev.carrico.repos.LearnerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@Transactional
public class LearnerRepoTests {

    @Autowired
    LearnerRepo learnerRepo;

    @Test
    void create_learner(){
        Learner learner = new Learner();
        learner.setUsername("notcarrico");
        learner.setPassword("password");
        learnerRepo.save(learner);

        Assertions.assertNotEquals(0, learner.getLearnerId());
    }

    @Test
    void get_all_learners(){
        Set<Learner> learners = new HashSet<>();
        this.learnerRepo.findAll().forEach(learners::add);
        System.out.println(learners);

        Assertions.assertTrue(learners.size() > 0);
    }

    @Test
    void get_learner_by_id(){
        Learner learner = this.learnerRepo.findById(1).get();
        Assertions.assertEquals(1, learner.getLearnerId());
    }

    @Test
    void get_learner_by_username(){
        Learner learner = this.learnerRepo.findByUsername("carrico");
        System.out.println(learner);
        Assertions.assertNotNull(learner);
    }

    @Test
    void update_learner(){
        Learner learner = this.learnerRepo.findById(1).get();
        learner.setPassword("new pass");
        this.learnerRepo.save(learner);
        learner = this.learnerRepo.findById(1).get();

        Assertions.assertTrue(learner.getPassword().equals("new pass"));
    }

    @Test
    void delete_learner(){
        Learner learner = this.learnerRepo.findById(1).get();
        this.learnerRepo.delete(learner);

        Assertions.assertFalse(this.learnerRepo.findById(1).isPresent());
    }

    @Test
    void delete_learner_by_id(){
        this.learnerRepo.deleteById(1);

        Assertions.assertFalse(this.learnerRepo.findById(1).isPresent());
    }
}
