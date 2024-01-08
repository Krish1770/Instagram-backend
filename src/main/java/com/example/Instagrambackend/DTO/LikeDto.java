package com.example.Instagrambackend.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LikeDto {
    private Boolean isCommentLike;

    private Boolean isFeedLike;

    private String commentId;

    private Long userId;

    private Long feedId;
}
