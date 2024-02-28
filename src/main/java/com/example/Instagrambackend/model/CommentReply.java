package com.example.Instagrambackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentReply extends CommentInfo{
    private String receiverCommentId;
    private User receiver;
}
