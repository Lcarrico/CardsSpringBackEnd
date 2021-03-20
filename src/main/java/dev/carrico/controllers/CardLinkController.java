package dev.carrico.controllers;

import dev.carrico.entities.CardLink;
import dev.carrico.services.CardLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
public class CardLinkController {
    @Autowired
    CardLinkService cardLinkService;

    @PostMapping("/cardLinks")
    @ResponseBody
    public CardLink createCardLink(@RequestBody CardLink cardLink){
        this.cardLinkService.createCardLink(cardLink);
        return cardLink;
    }

    @GetMapping("/cardLinks")
    @ResponseBody
    public Set<CardLink> getCardLinks(@RequestParam(name = "cardId", defaultValue = "") String cardId,
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
        return cardLinks;
    }

    @GetMapping("/cardLinks/{cardLinkId")
    @ResponseBody
    public CardLink getCardLinkById(@PathVariable int cardLinkId){
        try{
            CardLink cardLink = this.cardLinkService.getCardLinkById(cardLinkId);
            return cardLink;
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            emptyResultDataAccessException.printStackTrace();
            return null;
        }
    }

    @PutMapping("/cardLinks/{cardLinkId")
    @ResponseBody
    public CardLink updateCardLink(@PathVariable int cardLinkId, @RequestBody CardLink cardLink){
        cardLink.setCardLinkId(cardLinkId);
        this.cardLinkService.updateCardLink(cardLink);
        return cardLink;
    }

    @DeleteMapping("/cardLinks/{cardLinkId")
    @ResponseBody
    public Boolean deleteCardLinkById(@PathVariable int cardLinkId){
        Boolean result = this.cardLinkService.deleteCardLinkById(cardLinkId);
        return result;
    }

}
