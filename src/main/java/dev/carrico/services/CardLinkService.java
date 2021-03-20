package dev.carrico.services;

import dev.carrico.entities.CardLink;

import java.util.Set;

public interface CardLinkService {

    CardLink createCardLink(CardLink cardLink);

    CardLink getCardLinkById(int cardLinkId);
    Set<CardLink> getCardLinksByCardId(int cardId);
    Set<CardLink> getCardLinksByStackId(int stackId);
    Set<CardLink> getAllCardLinks();

    CardLink updateCardLink(CardLink cardLink);

    boolean deleteCardLinkById(int cardLinkId);
}
