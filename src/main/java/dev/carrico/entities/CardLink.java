package dev.carrico.entities;

import javax.persistence.*;

@Entity
@Table(name = "card_link")
public class CardLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_link_id")
    private int cardLinkId;

    @Column(name = "card_id")
    @JoinColumn(name = "card_id")
    private int cardId;

    @Column(name = "stack_id")
    @JoinColumn(name = "stack_id")
    private int stackId;

    public CardLink() {
    }

    public CardLink(int cardLinkId, int cardId, int stackId) {
        this.cardLinkId = cardLinkId;
        this.cardId = cardId;
        this.stackId = stackId;
    }

    public int getCardLinkId() {
        return cardLinkId;
    }

    public void setCardLinkId(int cardStackId) {
        this.cardLinkId = cardStackId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getStackId() {
        return stackId;
    }

    public void setStackId(int stackId) {
        this.stackId = stackId;
    }

    @Override
    public String toString() {
        return "CardLink{" +
                "cardLinkId=" + cardLinkId +
                ", cardId=" + cardId +
                ", stackId=" + stackId +
                '}';
    }
}
