package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.Card;
import dev.carrico.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
@CrossOrigin
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/cards")
    @Authorized
    public Card createCard(@RequestBody Card card) {
        this.cardService.createCard(card);
        return card;
    }

    @GetMapping("/cards/{cardId}")
    @Authorized
    public Card getCardById(@PathVariable int cardId) {
        Card card = this.cardService.getCardById(cardId);
        return card;
    }

    @GetMapping("/cards")
    @Authorized
    public Set<Card> getAllCards() {
        Set<Card> cards = this.cardService.getAllCards();
        return cards;
    }

    @PutMapping("/cards/{cardId}")
    @Authorized
    public Card updateCard(@PathVariable int cardId, @RequestBody Card card) {
        card.setCardId(cardId);
        this.cardService.updateCard(card);
        return card;
    }

    @DeleteMapping("/cards/{cardId}")
    @Authorized
    public Boolean deleteCardById(@PathVariable int cardId) {
        Boolean result = this.cardService.deleteCardById(cardId);
        return result;
    }
}