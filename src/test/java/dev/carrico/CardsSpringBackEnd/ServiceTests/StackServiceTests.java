package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Card;
import dev.carrico.entities.Stack;
import dev.carrico.entities.Topic;
import dev.carrico.services.CardService;
import dev.carrico.services.StackService;
import dev.carrico.services.TopicService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@SpringBootTest
@Transactional
public class StackServiceTests {
    @Autowired
    StackService ss;

    @Autowired
    CardService cs;

    @Autowired
    TopicService ts;

    @Test
    void create_stack(){
        Stack stack = new Stack();
        stack.setStackName("Math");
        ss.createStack(stack);

        Assertions.assertNotEquals(0, stack.getStackId());
    }

    @Test
    void get_stack_by_id(){
        Stack stack = ss.getStackById(1);

        Assertions.assertNotNull(stack);
        Assertions.assertTrue(stack.getStackName().equals("Basic Math"));
    }

    @Test
    void get_all_stacks(){
        Set<Stack> stacks = ss.getAllStacks();

        Assertions.assertNotNull(stacks);
        Assertions.assertTrue(stacks.size() > 0);
    }

    @Test
    void update_stack(){
        Stack stack = new Stack();
        stack.setStackId(1);
        stack.setStackName("Test Stack");
        stack.setDescription("Test Description");
        ss.updateStack(stack);
        stack = ss.getStackById(1);

        Assertions.assertTrue(stack.getStackName().equals("Test Stack"));
        Assertions.assertTrue(stack.getDescription().equals("Test Description"));
    }

    @Test
    void delete_stack(){
        boolean result = ss.deleteStackById(1);

        Assertions.assertTrue(result);
    }

}
