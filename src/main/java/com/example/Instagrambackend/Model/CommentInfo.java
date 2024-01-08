package com.example.Instagrambackend.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.bson.BsonObjectId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentInfo {

  private String id;

  private User sender;

  private String comment;

  private Date createdAt;
  private Likes likes;
    private List<CommentReply> replies;

    {
        likes = new Likes(new ArrayList<>());
    }


  {

  }


}




