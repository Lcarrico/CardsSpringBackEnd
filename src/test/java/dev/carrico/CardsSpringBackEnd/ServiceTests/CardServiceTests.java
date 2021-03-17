package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Card;
import dev.carrico.services.CardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@SpringBootTest
@Transactional
public class CardServiceTests {

    @Autowired
    CardService cs;

    @Test
    void create_card(){
        Card card = new Card();
        card.setQuestion("What is love?");
        card.setAnswer("Baby don't hurt meeee, no moreeee.");
        card.setCreatorId(1);
        cs.createCard(card);
        Assertions.assertNotEquals(0, card.getCardId());
    }

    @Test
    void get_card_by_id(){

    }

    @Test
    void get_all_cards(){
        Set<Card> cards = cs.getAllCards();
        System.out.println(cards);
    }

    @Test
    void update_card(){

    }

    @Test
    void delete_card(){

    }


}
