package com.example.Instagrambackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {


    private Long sender;

    private Long feedId;

    private String message;

    private Boolean isReply;

    private Long receiver;

    private String receiverCommentId;
}
