package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.CardLink;
import dev.carrico.services.CardLinkService;
import dev.carrico.services.CardService;
import dev.carrico.services.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Set;

@Component
@RestController
@CrossOrigin
public class CardLinkController {
    @Autowired
    CardLinkService cardLinkService;

    @Autowired
    StackService stackService;

    @Autowired
    CardService cardService;

    private void checkValidity(CardLink cardLink){
        Set<CardLink> cardLinks = this.cardLinkService.getCardLinksByCardId(cardLink.getCardId());
        for (CardLink cl: cardLinks) {
            if (cl.getStackId() == cardLink.getStackId()) {
                throw new DuplicateKeyException("CardLink already exists!");
            }
        }
        if (this.stackService.getStackById(cardLink.getStackId()) == null ||
                this.cardService.getCardById(cardLink.getCardId()) == null){
            throw new NoSuchElementException("Stack or Card does not exist. Unable to create link.");
        }
    }

    @PostMapping("/cardLinks")
    @Authorized
    public ResponseEntity<CardLink> createCardLink(@RequestBody CardLink cardLink){
        this.checkValidity(cardLink);
        cardLink = this.cardLinkService.createCardLink(cardLink);
        return ResponseEntity.status(201).body(cardLink);
    }

    @GetMapping("/cardLinks")
    public ResponseEntity<Set<CardLink>> getCardLinks(@RequestParam(name = "cardId", defaultValue = "") String cardId,
                                                      @RequestParam(name = "stackId", defaultValue = "") String stackId){
        Set<CardLink> cardLinks = null;
        if (stackId.isEmpty() && cardId.isEmpty()){
            cardLinks = this.cardLinkService.getAllCardLinks();
        }
        else  if (!cardId.isEmpty()){
            cardLinks = this.cardLinkService.getCardLinksByCardId(Integer.parseInt(cardId));
        }
        else if (!stackId.isEmpty()){
            cardLinks = this.cardLinkService.getCardLinksByStackId(Integer.parseInt(stackId));
        }
        return ResponseEntity.status(200).body(cardLinks);
    }

    @GetMapping("/cardLinks/{cardLinkId}")
    public ResponseEntity<CardLink> getCardLinkById(@PathVariable int cardLinkId){
        CardLink cardLink = this.cardLinkService.getCardLinkById(cardLinkId);
        return ResponseEntity.status(200).body(cardLink);
    }

    @PutMapping("/cardLinks/{cardLinkId}")
    @Authorized
    public ResponseEntity updateCardLink(@PathVariable int cardLinkId, @RequestBody CardLink cardLink){
        cardLink.setCardLinkId(cardLinkId);
        if (this.cardLinkService.getCardLinkById(cardLinkId) == null){
            throw new NoSuchElementException("Unable to update. This cardlink does not exist.");
        }
        this.cardLinkService.updateCardLink(cardLink);
        return ResponseEntity.status(200).body(cardLink);
    }

    @DeleteMapping("/cardLinks/{cardLinkId}")
    @Authorized
    public ResponseEntity<Boolean> deleteCardLinkById(@PathVariable int cardLinkId){
        Boolean result = this.cardLinkService.deleteCardLinkById(cardLinkId);
        return ResponseEntity.status(200).body(result);
    }

}
