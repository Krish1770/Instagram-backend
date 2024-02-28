package com.example.Instagrambackend.model;


import com.mongodb.annotations.Immutable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "feed_view")
@Immutable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedView
{
  @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedId;

    private boolean isArchived;

    private String name;

    private User userId;
}
