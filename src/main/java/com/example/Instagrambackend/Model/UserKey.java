package com.example.Instagrambackend.Model;


import jakarta.persistence.*;

@Embeddable
public class UserKey
{
    @ManyToOne(targetEntity = User.class,cascade= CascadeType.ALL)
    @JoinColumn(name = "sender",referencedColumnName = "userId")
    private User sender;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public UserKey() {
    }

    public UserKey(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @ManyToOne(targetEntity = User.class,cascade= CascadeType.ALL)
    @JoinColumn(name = "receiver",referencedColumnName = "userId")
    private User receiver;

}
