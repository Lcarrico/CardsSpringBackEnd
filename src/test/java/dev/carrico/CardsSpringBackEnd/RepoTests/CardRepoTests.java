package dev.carrico.CardsSpringBackEnd.RepoTests;

import dev.carrico.entities.Card;
import dev.carrico.repos.CardRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@SpringBootTest
@Transactional
public class CardRepoTests {

    @Autowired
    private CardRepo cardRepo;

    @Test
    void create_card(){
        Card card = new Card();
        card.setQuestion("What is 3+4?");
        card.setAnswer("7");
        this.cardRepo.save(card);
        System.out.println(card);

        Assertions.assertNotEquals(0, card.getCardId());
    }

    @Test
    void get_all_cards(){
        Set<Card> cards = new HashSet<>();
        this.cardRepo.findAll().forEach(cards::add);
        System.out.println(cards);

        Assertions.assertTrue(cards.size() > 0);
    }

    @Test
    void get_card_by_id(){
        Card card = this.cardRepo.findById(1).get();
        Assertions.assertNotNull(card);
        Assertions.assertEquals(1, card.getCardId());
    }

    @Test
    void update_card(){
        Card card = this.cardRepo.findById(1).get();
        card.setAnswer("something different");
        this.cardRepo.save(card);
        card = this.cardRepo.findById(1).get();

        Assertions.assertTrue(card.getAnswer().equals("something different"));
    }

    @Test
    void delete_card(){
        Card card = this.cardRepo.findById(1).get();
        this.cardRepo.delete(card);

        Assertions.assertNull(this.cardRepo.findById(1));
    }

    @Test
    void delete_card_by_id(){
        this.cardRepo.deleteById(1);

        Assertions.assertNull(this.cardRepo.findById(1));
    }
}
