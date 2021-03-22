package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.CardLink;
import dev.carrico.repos.CardLinkRepo;
import dev.carrico.services.CardLinkServiceImpl;
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
public class CardLinkServiceTests {

    @InjectMocks
    private CardLinkServiceImpl cardLinkService;

    @Mock
    private CardLinkRepo cardLinkRepo;

    @Test
    void create_cardlink(){
        Mockito.when(cardLinkRepo.save(any())).then(returnsFirstArg());

        CardLink cardLink = new CardLink();
        cardLink.setCardLinkId(9);
        cardLink.setCardId(1);
        cardLink.setStackId(1);
        cardLink = this.cardLinkService.createCardLink(cardLink);

        Assertions.assertEquals(0, cardLink.getCardLinkId());
    }
}
