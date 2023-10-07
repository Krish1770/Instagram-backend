package com.example.Instagrambackend.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Entity
@Table(name = "relation_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Relation {
    @EmbeddedId
    private UserKey userKey;
    private String status;

    private boolean following;
    private String followingRequest;

    }
