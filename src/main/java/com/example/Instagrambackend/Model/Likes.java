package com.example.Instagrambackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Likes")
public class Likes {
    public Long getFeedId() {
        return feedId;
    }

    public void setFeedId(Long feedId) {
        this.feedId = feedId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Id
    @OneToOne(targetEntity = Feed.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "feedId",referencedColumnName = "feedId")
    private Long feedId;

    private Long userId;

    private Boolean status;
}
