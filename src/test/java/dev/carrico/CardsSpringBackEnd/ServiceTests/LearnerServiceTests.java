package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Learner;
import dev.carrico.repos.LearnerRepo;
import dev.carrico.services.LearnerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LearnerServiceTests {

    @InjectMocks
    private LearnerServiceImpl learnerService;

    @Mock
    private LearnerRepo learnerRepo;

    @Test
    void create_learner(){
        Mockito.when(learnerRepo.save(any())).then(returnsFirstArg());

        Learner learner = new Learner();
        learner.setLearnerId(9);
        learner.setUsername("AwesomeNickName");
        learner.setPassword("password");
        learner = this.learnerService.createLearner(learner);

        Assertions.assertEquals(0, learner.getLearnerId());
    }
}
