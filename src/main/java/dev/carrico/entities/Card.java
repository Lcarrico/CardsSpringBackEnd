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

    @Column(name = "creator_id")
    @JoinColumn(name="creator_id")
    private int creatorId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_stack",
        joinColumns = {@JoinColumn(name="card_id")},
        inverseJoinColumns = {@JoinColumn(name="stack_id")}
    )
    private Set<Stack> stacks = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_tag",
            joinColumns = {@JoinColumn(name="card_id")},
            inverseJoinColumns = {@JoinColumn(name="tag_id")}
    )
    private Set<Tag> tags = new HashSet<>();

    public Card(int cardId, String question, String answer, int creatorId, Set<Stack> stacks, Set<Tag> tags) {
        this.cardId = cardId;
        this.question = question;
        this.answer = answer;
        this.creatorId = creatorId;
        this.stacks = stacks;
        this.tags = tags;
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

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public Set<Stack> getStacks() {
        return stacks;
    }

    public void setStacks(Set<Stack> stacks) {
        this.stacks = stacks;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", creatorId=" + creatorId +
                ", tags=" + tags +
                '}';
    }
}
