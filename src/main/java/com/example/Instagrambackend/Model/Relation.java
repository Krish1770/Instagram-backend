package com.example.Instagrambackend.Model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.HttpStatus;
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
