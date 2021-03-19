package dev.carrico.CardsSpringBackEnd.RepoTests;

import dev.carrico.entities.CardStack;
import dev.carrico.repos.CardStackRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CardStackRepoTests {

    @Autowired
    private CardStackRepo cardStackRepo;

    @Test
    void create_card_stack(){
        CardStack cardStack = new CardStack();
        cardStack.setCardId(1);
        cardStack.setStackId(2);
        this.cardStackRepo.save(cardStack);

        Assertions.assertNotEquals(0, cardStack.getCardStackId());
    }

    @Test
    void get_card_stack_by_stack_id(){
        // TODO
    }

    @Test
    void get_card_stack_by_card_id(){
        // TODO
    }

    @Test
    void delete_card_stack(){
        // TODO
    }
}
