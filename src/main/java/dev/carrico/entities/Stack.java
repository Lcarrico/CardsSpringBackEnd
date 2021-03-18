package dev.carrico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="stack")
public class Stack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stack_id")
    private int stackId;

    @Column(name = "stack_name")
    private String stackName;

    @Column(name = "description")
    private String description;

    @Column(name = "creator_id")
    @JoinColumn(name = "creator_id")
    private int creatorId;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "learner_stack",
            joinColumns = {@JoinColumn(name="stack_id")},
            inverseJoinColumns = {@JoinColumn(name="learner_id")}
    )
    private Set<Learner> learners = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_stack",
            joinColumns = {@JoinColumn(name="stack_id")},
            inverseJoinColumns = {@JoinColumn(name="card_id")}
    )
    private Set<Card> cards = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stack_tag",
            joinColumns = {@JoinColumn(name="stack_id")},
            inverseJoinColumns = {@JoinColumn(name="tag_id")}
    )
    private Set<Tag> tags = new HashSet<>();

    public Stack(int stackId, String stackName, String description, int creatorId, Set<Learner> learners, Set<Card> cards, Set<Tag> tags) {
        this.stackId = stackId;
        this.stackName = stackName;
        this.description = description;
        this.creatorId = creatorId;
        this.learners = learners;
        this.cards = cards;
        this.tags = tags;
    }

    public Stack(){}

    public int getStackId() {
        return stackId;
    }

    public void setStackId(int stackId) {
        this.stackId = stackId;
    }

    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public Set<Learner> getLearners() {
        return learners;
    }

    public void setLearners(Set<Learner> learners) {
        this.learners = learners;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stackId=" + stackId +
                ", stackName='" + stackName + '\'' +
                ", description='" + description + '\'' +
                ", creatorId=" + creatorId +
                ", cards=" + cards +
                ", tags=" + tags +
                '}';
    }
}
