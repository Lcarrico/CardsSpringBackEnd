package dev.carrico.CardsSpringBackEnd.RepoTests;

import dev.carrico.entities.StackLink;
import dev.carrico.repos.StackLinkRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@Transactional
public class StackLinkRepoTests {
    
    @Autowired
    StackLinkRepo stackLinkRepo;
    
    @Test
    void create_stack_link(){
        StackLink stackLink = new StackLink();
        stackLink.setStackId(1);
        stackLink.setLearnerId(1);
        stackLink.setRelationship("Creator");
        this.stackLinkRepo.save(stackLink);
        System.out.println(stackLink);

        Assertions.assertNotEquals(0, stackLink.getStackLinkId());
    }

    @Test
    void get_stack_link_by_id(){
        StackLink stackLink = this.stackLinkRepo.findById(1).get();
        Assertions.assertNotNull(stackLink);
    }

    @Test
    void get_all_stack_links(){
        Set<StackLink> stackLinks = new HashSet<>();
        this.stackLinkRepo.findAll().forEach(stackLinks::add);
        System.out.println(stackLinks);

        Assertions.assertTrue(stackLinks.size() > 0);
    }

    @Test
    void get_stack_links_by_learner_id(){
        Set<StackLink> stackLinks = this.stackLinkRepo.findByLearnerId(1);
        Assertions.assertTrue(stackLinks.size() > 0);
    }

//    @Test
//    void get_stack_links_by_stack_id(){
//        TODO// probably dont need
//        Set<StackLink> stackLinks = this.stackLinkRepo.findByStackId()
//    }

    @Test
    void get_stack_links_by_relationship(){
        Set<StackLink> stackLinks = this.stackLinkRepo.findByRelationship("Creator");
        Assertions.assertTrue(stackLinks.size() > 0);
    }

    @Test
    void delete_stack_link(){
        StackLink stackLink = this.stackLinkRepo.findById(1).get();
        this.stackLinkRepo.delete(stackLink);

        Assertions.assertFalse(this.stackLinkRepo.findById(1).isPresent());
    }

    @Test
    void delete_stack_link_by_id(){
        this.stackLinkRepo.deleteById(1);

        Assertions.assertFalse(this.stackLinkRepo.findById(1).isPresent());
    }
}
