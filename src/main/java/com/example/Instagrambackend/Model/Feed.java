package com.example.Instagrambackend.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="feed")
public class Feed {

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User userId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedId;

    @OneToOne(targetEntity = Media.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "mediaId")
    private Media media;

    private Date uploadDate;

    private boolean isArchived;

    private String privacyType;


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }



    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }


    public Long getFeedId() {
        return feedId;
    }

    public void setFeedId(Long feedId) {
        this.feedId = feedId;
    }



    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public String getPrivacyType() {
        return privacyType;
    }

    public void setPrivacyType(String privacyType) {
        this.privacyType = privacyType;
    }

}
