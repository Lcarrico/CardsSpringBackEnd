package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Card;
import dev.carrico.repos.CardRepo;
import dev.carrico.services.CardServiceImpl;
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
public class CardServiceTests {

    @InjectMocks
    private CardServiceImpl cardService;

    @Mock
    private CardRepo cardRepo;

    @Test
    void create_card(){
        Mockito.when(cardRepo.save(any())).then(returnsFirstArg());

        Card card = new Card();
        card.setCardId(5);
        card.setQuestion("What is love?");
        card.setAnswer("Baby don't hurt meeee, no moreeee.");
        card = this.cardService.createCard(card);

        Assertions.assertEquals(0, card.getCardId());
    }
}
