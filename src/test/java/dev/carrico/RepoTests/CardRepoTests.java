package dev.carrico.RepoTests;

import dev.carrico.entities.Card;
import dev.carrico.repos.CardRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Transactional
@SpringBootTest
public class CardRepoTests {

    @Autowired
    CardRepo cardRepo;

    @Test
    void create_card(){
        Card card = new Card();
        card.setQuestion("What is 3+4?");
        card.setAnswer("7");
        card.setCreatorId(1);
        cardRepo.save(card);
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

}
