package com.example.Instagrambackend.model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "FeedInfo")
public class FeedInfo {

    @Id
    private String id;

    private Long feedId;

    private Likes feedLikes;

    private List<CommentInfo> commentInfo;
}
