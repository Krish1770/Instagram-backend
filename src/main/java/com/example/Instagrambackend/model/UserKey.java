package com.example.Instagrambackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class UserKey
{
    @ManyToOne(targetEntity = User.class,cascade= CascadeType.ALL)
    @JoinColumn(name = "sender",referencedColumnName = "userId")
    private User sender;

    @ManyToOne(targetEntity = User.class,cascade= CascadeType.ALL)
    @JoinColumn(name = "receiver",referencedColumnName = "userId")
    private User receiver;

}
