package dev.carrico.entities;

import javax.persistence.*;

@Entity
@Table(name = "tag_link")
public class TagLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_link_id")
    private int tagLinkId;

    @Column(name = "tag_id")
    @JoinColumn(name = "tag_id")
    private int tagId;

    @Column(name = "card_id")
    @JoinColumn(name = "card_id")
    private int cardId;

    public TagLink() {
    }

    public TagLink(int tagLinkId, int tagId, int cardId) {
        this.tagLinkId = tagLinkId;
        this.tagId = tagId;
        this.cardId = cardId;
    }

    public int getTagLinkId() {
        return tagLinkId;
    }

    public void setTagLinkId(int tagLinkId) {
        this.tagLinkId = tagLinkId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "TagLink{" +
                "tagLinkId=" + tagLinkId +
                ", tagId=" + tagId +
                ", cardId=" + cardId +
                '}';
    }
}
