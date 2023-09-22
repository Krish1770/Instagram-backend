package com.example.Instagrambackend.Model;


import jakarta.persistence.*;
import org.springframework.http.HttpStatus;

@Entity
@Table(name = "relation_list")
public class Relation {
    @EmbeddedId
    private UserKey userKey;

    public Relation(HttpStatus httpStatus, String s, String s1) {
    }

    public Relation() {

    }

    public UserKey getUserKey() {
        return userKey;
    }

    public Relation(UserKey userKey, String status, boolean following) {
        this.userKey = userKey;
        this.status = status;
        this.following = following;
    }

    public void setUserKey(UserKey userKey) {
        this.userKey = userKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    private String status;

    private boolean following;

    public void setUserKey(User sender, User receiver) {
        this.userKey = new UserKey(sender, receiver);
    }
}
