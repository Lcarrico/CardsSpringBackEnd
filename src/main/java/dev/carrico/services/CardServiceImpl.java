package dev.carrico.services;

import dev.carrico.entities.Card;
import dev.carrico.repos.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class CardServiceImpl implements CardService{

    @Autowired
    CardRepo cardRepo;

    @Override
    public Card createCard(Card card) {
        card.setCardId(0);
        this.cardRepo.save(card);
        return card;
    }

    @Override
    public Card getCardById(int cardId) {
        Card card = this.cardRepo.findById(cardId).get();
        return card;
    }

    @Override
    public Set<Card> getAllCards() {
        Set<Card> cards = new HashSet<>();
        this.cardRepo.findAll().forEach(cards::add);
        return cards;
    }

    @Override
    public Card updateCard(Card card) {
        cardRepo.save(card);
        return card;
    }

    @Override
    public boolean deleteCardById(int cardId) {
        this.cardRepo.deleteById(cardId);
        return true;
    }
}
