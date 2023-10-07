package com.example.Instagrambackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

    private String name;

    private byte[] data;

    private String type;


}