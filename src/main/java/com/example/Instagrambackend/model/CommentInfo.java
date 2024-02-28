package com.example.Instagrambackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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




