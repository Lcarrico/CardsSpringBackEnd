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

        Assertions.assertTrue(stacks.size() > 0);
    }

    @Test
    void get_stack_by_id(){
        Stack stack = this.stackRepo.findById(1).get();

        Assertions.assertEquals(1, stack.getStackId());
    }

    @Test
    void get_stack_by_stack_name(){
        // TODO
    }

    @Test
    void get_stack_by_stack_description(){
        // TODO
    }

    @Test
    void update_stack(){
        Stack stack = this.stackRepo.findById(1).get();
        stack.setDescription("a random description");
        this.stackRepo.save(stack);
        stack = this.stackRepo.findById(1).get();

        Assertions.assertTrue(stack.getDescription().equals("a random description"));
    }

    @Test
    void delete_stack(){
        Stack stack = this.stackRepo.findById(1).get();
        this.stackRepo.delete(stack);

        Assertions.assertFalse(this.stackRepo.findById(1).isPresent());
    }

    @Test
    void delete_stack_by_id(){
        this.stackRepo.deleteById(1);

        Assertions.assertFalse(this.stackRepo.findById(1).isPresent());
    }

}
