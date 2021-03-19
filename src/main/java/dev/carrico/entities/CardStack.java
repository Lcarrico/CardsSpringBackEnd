package dev.carrico.entities;

import javax.persistence.*;

@Entity
@Table(name = "card_stack")
public class CardStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_stack_id")
    private int cardStackId;

    @Column(name = "card_id")
    @JoinColumn(name = "card_id")
    private int cardId;

    @Column(name = "stack_id")
    @JoinColumn(name = "stack_id")
    private int stackId;

    public CardStack() {
    }

    public CardStack(int cardStackId, int cardId, int stackId) {
        this.cardStackId = cardStackId;
        this.cardId = cardId;
        this.stackId = stackId;
    }

    public int getCardStackId() {
        return cardStackId;
    }

    public void setCardStackId(int cardStackId) {
        this.cardStackId = cardStackId;
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
        return "CardStack{" +
                "cardStackId=" + cardStackId +
                ", cardId=" + cardId +
                ", stackId=" + stackId +
                '}';
    }
}
