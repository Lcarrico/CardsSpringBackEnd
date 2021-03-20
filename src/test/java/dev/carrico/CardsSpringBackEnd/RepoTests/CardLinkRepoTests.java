package dev.carrico.CardsSpringBackEnd.RepoTests;

import dev.carrico.entities.CardLink;
import dev.carrico.repos.CardLinkRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@Transactional
public class CardLinkRepoTests {

    @Autowired
    private CardLinkRepo cardLinkRepo;

    @Test
    void create_card_stack(){
        CardLink cardLink = new CardLink();
        cardLink.setCardId(1);
        cardLink.setStackId(2);
        this.cardLinkRepo.save(cardLink);

        Assertions.assertNotEquals(0, cardLink.getCardLinkId());
    }

    @Test
    void get_card_link_by_id(){
        CardLink cardLink = this.cardLinkRepo.findById(1).get();
        Assertions.assertNotNull(cardLink);
        Assertions.assertEquals(1, cardLink.getCardLinkId());
    }

    @Test
    void get_card_link_by_card_id(){
        Set<CardLink> cardLinks = this.cardLinkRepo.findByCardId(1);
        Assertions.assertTrue(cardLinks.size() > 0);
    }

    @Test
    void get_card_link_by_stack_id(){
        Set<CardLink> cardLinks = this.cardLinkRepo.findByStackId(1);
        Assertions.assertTrue(cardLinks.size() > 0);
    }

    @Test
    void get_all_card_links(){
        Set<CardLink> cardLinks = new HashSet<>();
        this.cardLinkRepo.findAll().forEach(cardLinks::add);
        System.out.println(cardLinks);

        Assertions.assertTrue(cardLinks.size() > 0);
    }

    @Test
    void update_card_link(){
        CardLink cardLink = this.cardLinkRepo.findById(1).get();
        cardLink.setCardId(2);
        cardLink.setStackId(2);
        this.cardLinkRepo.save(cardLink);
        cardLink = this.cardLinkRepo.findById(1).get();

        Assertions.assertEquals(2, cardLink.getCardId());
        Assertions.assertEquals(2, cardLink.getStackId());
    }

    @Test
    void delete_card_link(){
        CardLink cardLink = this.cardLinkRepo.findById(1).get();
        this.cardLinkRepo.delete(cardLink);

        Assertions.assertNull(this.cardLinkRepo.findById(1));
    }

    @Test
    void delete_card_link_by_id(){
        this.cardLinkRepo.deleteById(1);

        Assertions.assertNull(this.cardLinkRepo.findById(1));
    }
}
