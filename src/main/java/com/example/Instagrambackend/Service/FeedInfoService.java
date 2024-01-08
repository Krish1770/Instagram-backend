package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.DTO.CommentDto;
import com.example.Instagrambackend.DTO.LikeDto;
import com.example.Instagrambackend.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface FeedInfoService {
    public ResponseEntity<ResponseDTO> addComments(CommentDto commentDto);

    ResponseEntity<ResponseDTO> manageLikes(LikeDto likeDto);
}
