package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.Card;
import dev.carrico.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Set;

@Component
@RestController
@CrossOrigin
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/cards")
    @Authorized
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        this.cardService.createCard(card);
        return ResponseEntity.status(201).body(card);
    }

    @GetMapping("/cards/{cardId}")
    public ResponseEntity<Card> getCardById(@PathVariable int cardId) {
        Card card = this.cardService.getCardById(cardId);
        return ResponseEntity.status(200).body(card);
    }

    @GetMapping("/cards")
    public ResponseEntity<Set<Card>> getAllCards() {
        Set<Card> cards = this.cardService.getAllCards();
        return ResponseEntity.status(200).body(cards);
    }

    @PutMapping("/cards/{cardId}")
    @Authorized
    public ResponseEntity<Card> updateCard(@PathVariable int cardId, @RequestBody Card card) {
        card.setCardId(cardId);
        if (this.cardService.getCardById(cardId) == null){
            throw new NoSuchElementException("Unable to update. This card does not exist.");
        }
        this.cardService.updateCard(card);
        return ResponseEntity.status(200).body(card);
    }

    @DeleteMapping("/cards/{cardId}")
    @Authorized
    public ResponseEntity<Boolean> deleteCardById(@PathVariable int cardId) {
        Boolean result = this.cardService.deleteCardById(cardId);
        return ResponseEntity.status(200).body(result);
    }
}