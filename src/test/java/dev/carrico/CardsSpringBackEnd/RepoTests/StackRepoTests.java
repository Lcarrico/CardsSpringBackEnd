package dev.carrico.CardsSpringBackEnd.RepoTests;

import dev.carrico.entities.Stack;
import dev.carrico.repos.StackRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
@SpringBootTest
public class StackRepoTests {

    @Autowired
    StackRepo stackRepo;

    @Test
    void create_stack(){
        Stack stack = new Stack();
        stack.setStackName("Basic Math");
        stack.setDescription("Very basic single digit math problems.");
        stackRepo.save(stack);
        System.out.println(stack);
        Assertions.assertNotEquals(0, stack.getStackId());
    }

    @Test
    void get_all_stacks(){
        Set<Stack> stacks = new HashSet<>();
        this.stackRepo.findAll().forEach(stacks::add);
        System.out.println(stacks);
        stacks.forEach(stack -> System.out.println(stack.getLearners()));
        Assertions.assertTrue(stacks.size() > 0);
    }

}
