package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.Card;
import dev.carrico.entities.Tag;
import dev.carrico.services.CardService;
import dev.carrico.services.TagService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Set;

@SpringBootTest
@Transactional
public class CardServiceTests {

    @Autowired
    CardService cs;

    @Autowired
    TagService ts;

    @Test
    void create_card(){
        Card card = new Card();
        card.setQuestion("What is love?");
        card.setAnswer("Baby don't hurt meeee, no moreeee.");
        card.setCreatorId(1);
        this.cs.createCard(card);
        Assertions.assertNotEquals(0, card.getCardId());
    }

    @Test
    void get_card_by_id(){
        Card card = this.cs.getCardById(3);
        Assertions.assertNotNull(card);
    }

    @Test
    void get_all_cards(){
        Set<Card> cards = cs.getAllCards();
        System.out.println(cards);
        Assertions.assertTrue(cards.size() > 0);
    }

    @Test
    void update_card(){
        Card card = this.cs.getCardById(3);
        card.setAnswer("Magical Protein");
        this.cs.updateCard(card);
        Assertions.assertEquals("Magical Protein", this.cs.getCardById(3).getAnswer());

    }

    @Test
    void delete_card(){
        boolean result = this.cs.deleteCardById(3);
        Assertions.assertTrue(result);
    }

    @Test
    void add_tag_to_card(){
        Tag tag = ts.getTagById(7);
        Card card = cs.getCardById(4);

        cs.addTagToCard(card, tag);

        Set<Tag> tags = cs.getCardById(4).getTags();
        System.out.println(tags);
        Assertions.assertTrue(tags.size() > 0);

    }

    @Test
    void remove_tag_from_card(){
        Tag tag = ts.getTagById(7);
        Card card = cs.getCardById(4);

        cs.removeTagFromCard(card, tag);

        Set<Tag> tags = cs.getCardById(4).getTags();
        Assertions.assertTrue(!tags.contains(tag));

    }


}
