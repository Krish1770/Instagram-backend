package com.example.Instagrambackend.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "relation_list")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Relation {
    @EmbeddedId
    private UserKey userKey;
    private String status;

    private boolean following;
    private String followingRequest;

    }
