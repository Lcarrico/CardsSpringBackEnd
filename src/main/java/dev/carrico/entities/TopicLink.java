package dev.carrico.entities;

import javax.persistence.*;

@Entity
@Table(name = "topic_link")
public class TopicLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_link_id")
    private int topicLinkId;

    @Column(name = "topic_id")
    @JoinColumn(name = "topic_id")
    private int topicId;

    @Column(name = "stack_id")
    @JoinColumn(name = "stack_id")
    private int stackId;

    public TopicLink() {
    }

    public TopicLink(int topicLinkId, int topicId, int stackId) {
        this.topicLinkId = topicLinkId;
        this.topicId = topicId;
        this.stackId = stackId;
    }

    public int getTopicLinkId() {
        return topicLinkId;
    }

    public void setTopicLinkId(int topicLinkId) {
        this.topicLinkId = topicLinkId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getStackId() {
        return stackId;
    }

    public void setStackId(int stackId) {
        this.stackId = stackId;
    }

    @Override
    public String toString() {
        return "TopicLink{" +
                "topicLinkId=" + topicLinkId +
                ", topicId=" + topicId +
                ", stackId=" + stackId +
                '}';
    }
}
