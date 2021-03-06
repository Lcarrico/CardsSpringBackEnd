package dev.carrico.services;

import dev.carrico.entities.Card;

import java.util.Set;

public interface CardService {

    Card createCard(Card card);

    Card getCardById(int cardId);
    Set<Card> getAllCards();

    Card updateCard(Card card);

    boolean deleteCardById(int cardId);
}
