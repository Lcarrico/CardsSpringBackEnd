package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Stack;
import dev.carrico.repos.StackRepo;
import dev.carrico.services.StackServiceImpl;
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
public class StackServiceTests {

    @InjectMocks
    private StackServiceImpl stackService;

    @Mock
    private StackRepo stackRepo;

    @Test
    void create_stack(){
        Mockito.when(stackRepo.save(any())).then(returnsFirstArg());

        Stack stack = new Stack();
        stack.setStackId(9);
        stack.setStackName("Math");
        stack = this.stackService.createStack(stack);

        Assertions.assertEquals(0, stack.getStackId());
    }

}
