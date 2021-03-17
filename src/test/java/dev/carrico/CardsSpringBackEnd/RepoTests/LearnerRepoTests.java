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

}
