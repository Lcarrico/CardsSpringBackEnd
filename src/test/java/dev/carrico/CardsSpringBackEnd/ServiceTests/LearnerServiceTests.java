package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Learner;
import dev.carrico.entities.Stack;
import dev.carrico.services.LearnerService;
import dev.carrico.services.StackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Set;

@SpringBootTest
@Transactional
public class LearnerServiceTests {

    @Autowired
    LearnerService ls;

    @Autowired
    StackService ss;

    @Test
    void create_learner(){
        Learner learner = new Learner();
        learner.setUsername("AwesomeNickName");
        learner.setPassword("password");
        this.ls.createLearner(learner);
        Assertions.assertNotEquals(0, learner.getLearnerId());

    }

    @Test
    void get_learner_by_id(){
        Learner learner = this.ls.getLearnerById(2);
        Assertions.assertNotNull(learner);

    }

    @Test
    void get_all_learners(){
        Set<Learner> learners = this.ls.getAllLearners();
        Assertions.assertTrue(learners.size() > 0);
    }

    @Test
    void update_learner(){
        Learner learner = this.ls.getLearnerById(2);
        learner.setPassword("passcode123");
        this.ls.updateLearner(learner);
        Assertions.assertEquals("passcode123", this.ls.getLearnerById(2).getPassword());

    }

    @Test
    void delete_learner_by_id(){
        boolean result = this.ls.deleteLearnerById(2);
        Assertions.assertTrue(result);
    }

    @Test
    void get_learner_by_username_and_password(){
        Learner learner = this.ls.getByUsernameAndPassword("carrico", "password");
        Assertions.assertNotNull(learner);

        learner = this.ls.getByUsernameAndPassword("caafrrico", "passwosdgrd");
        Assertions.assertNull(learner);

    }

//    @Test
//    void add_stack_to_learner(){
//        Learner learner = this.ls.getLearnerById(2);
//        Stack stack = this.ss.getStackById(1);
//
//        this.ls.addStackToLearner(learner, stack);
//
//        learner = this.ls.getLearnerById(2);
//        Assertions.assertTrue(learner.getStacks().size() > 0);
//    }

//    @Test
//    void remove_stack_from_learner(){
//        Learner learner = this.ls.getLearnerById(2);
//        Stack stack = this.ss.getStackById(1);
//
//        this.ls.removeStackFromLearner(learner, stack);
//
//        learner = this.ls.getLearnerById(2);
//        Assertions.assertTrue(!learner.getStacks().contains(stack));
//    }
}
