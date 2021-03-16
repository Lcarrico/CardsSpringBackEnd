package dev.carrico.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= " tag_id")
    private int tagId;

    @Column(name = "tag_name")
    private String tagName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_tag",
            joinColumns = {@JoinColumn(name="tag_id")},
            inverseJoinColumns = {@JoinColumn(name="card_id")}
    )
    private Set<Card> cards = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stack_tag",
            joinColumns = {@JoinColumn(name="tag_id")},
            inverseJoinColumns = {@JoinColumn(name="stack_id")}
    )
    private Set<Stack> stacks = new HashSet<>();

    public Tag(int tagId, String tagName, Set<Card> cards, Set<Stack> stacks) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.cards = cards;
        this.stacks = stacks;
    }

    public Tag(){}

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<Stack> getStacks() {
        return stacks;
    }

    public void setStacks(Set<Stack> stacks) {
        this.stacks = stacks;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", cards=" + cards +
                ", stacks=" + stacks +
                '}';
    }
}
