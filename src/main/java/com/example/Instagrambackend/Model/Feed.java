package com.example.Instagrambackend.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="feed")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


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

}

