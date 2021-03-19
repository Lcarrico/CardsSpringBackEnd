package dev.carrico.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int cardId;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    public Card(int cardId, String question, String answer) {
        this.cardId = cardId;
        this.question = question;
        this.answer = answer;
    }

    public Card(){

    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
