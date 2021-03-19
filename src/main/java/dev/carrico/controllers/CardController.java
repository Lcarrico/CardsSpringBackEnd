package dev.carrico.controllers;

import dev.carrico.entities.Card;
import dev.carrico.entities.Tag;
import dev.carrico.services.CardService;
import dev.carrico.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
public class CardController {

    @Autowired
    CardService cardService;

    @Autowired
    TagService tagService;

    @PostMapping("/cards")
    public Card createCard(@RequestBody Card card) {
        this.cardService.createCard(card);
        return card;
    }

    @GetMapping("/cards/{cardId}")
    public Card getCardById(@PathVariable int cardId) {
        Card card = this.cardService.getCardById(cardId);
        return card;
    }

    @GetMapping("/cards")
    public Set<Card> getAllCards() {
        Set<Card> cards = this.cardService.getAllCards();
        return cards;
    }

    @PutMapping("/cards/{cardId}")
    public Card updateCard(@PathVariable int cardId, @RequestBody Card card) {
        card.setCardId(cardId);
        this.cardService.updateCard(card);
        return card;
    }

    @DeleteMapping("/cards/{cardId}")
    public Boolean deleteBookById(@PathVariable int cardId) {
        Boolean result = this.cardService.deleteCardById(cardId);
        return result;
    }

    @PostMapping("/cards/{cardId}/tags/{tagId}")
    @PutMapping("/cards/{cardId}/tags/{tagId}")
    public Card addTagToCard(@PathVariable int cardId, @PathVariable int tagId) {
        Card card = this.cardService.getCardById(cardId);
        Tag tag = this.tagService.getTagById(tagId);
//        this.cardService.addTagToCard(card, tag);
        return card;
    }

    @DeleteMapping("/cards/{cardId}/tags/{tagId}")
    public Boolean removeTagFromCard(@PathVariable int cardId, @PathVariable int tagId){
        Card card = this.cardService.getCardById(cardId);
        Tag tag = this.tagService.getTagById(tagId);

//        Boolean result = this.cardService.removeTagFromCard(card, tag);
        return true;
    }

}