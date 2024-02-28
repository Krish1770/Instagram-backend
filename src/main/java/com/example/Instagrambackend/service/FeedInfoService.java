package com.example.Instagrambackend.service;

import com.example.Instagrambackend.dto.CommentDto;
import com.example.Instagrambackend.dto.LikeDto;
import com.example.Instagrambackend.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface FeedInfoService {
    public ResponseEntity<ResponseDTO> addComments(CommentDto commentDto);

    ResponseEntity<ResponseDTO> manageLikes(LikeDto likeDto);
}
