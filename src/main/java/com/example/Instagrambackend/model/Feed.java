package com.example.Instagrambackend.model;


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

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User userId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedId;

    @ManyToOne(targetEntity = Category.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId",referencedColumnName ="categoryId" )
    private Category categoryId;

    @OneToOne(targetEntity = Media.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "mediaId")
    private Media media;

    @Column(name = "uploadDate")
    private Date uploadDate;

    @Column(name = "isArchived")
    private boolean isArchived;

    @Column(name = "privacyType")
    private String privacyType;


}

