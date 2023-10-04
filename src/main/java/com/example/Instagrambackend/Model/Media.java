package com.example.Instagrambackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

    private String name;

    private byte[] data;

    private String type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}