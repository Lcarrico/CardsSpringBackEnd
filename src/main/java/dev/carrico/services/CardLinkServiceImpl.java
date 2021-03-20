package dev.carrico.services;

import dev.carrico.entities.CardLink;
import dev.carrico.repos.CardLinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class CardLinkServiceImpl implements CardLinkService{
    @Autowired
    private CardLinkRepo cardLinkRepo;

    @Override
    public CardLink createCardLink(CardLink cardLink) {
        this.cardLinkRepo.save(cardLink);
        return cardLink;
    }

    @Override
    public CardLink getCardLinkById(int cardLinkId) {
        CardLink cardLink = this.cardLinkRepo.findById(cardLinkId).get();
        return cardLink;
    }

    @Override
    public Set<CardLink> getCardLinksByCardId(int cardId) {
        Set<CardLink> cardLinks = this.cardLinkRepo.findByCardId(cardId);
        return cardLinks;
    }

    @Override
    public Set<CardLink> getCardLinksByStackId(int stackId) {
        Set<CardLink> cardLinks = this.cardLinkRepo.findByStackId(stackId);
        return cardLinks;
    }

    @Override
    public Set<CardLink> getAllCardLinks() {
        Set<CardLink> cardLinks = new HashSet<>();
        this.cardLinkRepo.findAll().forEach(cardLinks::add);
        return cardLinks;
    }

    @Override
    public CardLink updateCardLink(CardLink cardLink) {
        this.cardLinkRepo.save(cardLink);
        return cardLink;
    }

    @Override
    public boolean deleteCardLinkById(int cardLinkId) {
        this.cardLinkRepo.deleteById(cardLinkId);
        return true;
    }
}
