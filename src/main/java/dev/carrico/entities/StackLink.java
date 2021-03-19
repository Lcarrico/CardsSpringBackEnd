package dev.carrico.entities;

import javax.persistence.*;

@Entity
@Table(name = "stack_link")
public class StackLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stack_link_id")
    private int stackLinkId;

    @Column(name = "learner_id")
    @JoinColumn(name = "learner_id")
    private int learnerId;

    @Column(name = "stack_id")
    @JoinColumn(name = "stack_id")
    private int stackId;

    @Column(name = "relationship")
    private String relationship;

    public StackLink() {
    }

    public StackLink(int stackLinkId, int learnerId, int stackId, String relationship) {
        this.stackLinkId = stackLinkId;
        this.learnerId = learnerId;
        this.stackId = stackId;
        this.relationship = relationship;
    }

    public int getStackLinkId() {
        return stackLinkId;
    }

    public void setStackLinkId(int stackLinkId) {
        this.stackLinkId = stackLinkId;
    }

    public int getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(int learnerId) {
        this.learnerId = learnerId;
    }

    public int getStackId() {
        return stackId;
    }

    public void setStackId(int stackId) {
        this.stackId = stackId;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "StackLink{" +
                "stackLinkId=" + stackLinkId +
                ", learnerId=" + learnerId +
                ", stackId=" + stackId +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}
