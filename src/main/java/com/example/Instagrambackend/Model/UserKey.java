package com.example.Instagrambackend.Model;


import jakarta.persistence.*;

@Embeddable
public class UserKey
{
    @ManyToOne(targetEntity = User.class,cascade= CascadeType.ALL)
    @JoinColumn(name = "sender",referencedColumnName = "userId")
    private Long sender;

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    @ManyToOne(targetEntity = User.class,cascade= CascadeType.ALL)
    @JoinColumn(name = "receiver",referencedColumnName = "userId")
    private Long receiver;

}
