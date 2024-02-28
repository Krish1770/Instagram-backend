package com.example.Instagrambackend.controller;


import com.example.Instagrambackend.api.FeedInfoApi;
import com.example.Instagrambackend.dto.CommentDto;
import com.example.Instagrambackend.dto.LikeDto;
import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.service.FeedInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeedInfoController implements FeedInfoApi {

    @Autowired
    private FeedInfoService feedInfoService;
    @Override
    public ResponseEntity<ResponseDTO> addComments(CommentDto commentDto) {

        return feedInfoService.addComments(commentDto);
    }

    @Override
    public ResponseEntity<ResponseDTO> manageLikes(LikeDto likeDto) {
        return feedInfoService.manageLikes(likeDto);
    }
}
