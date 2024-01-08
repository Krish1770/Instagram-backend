package com.example.Instagrambackend.Controller;


import com.example.Instagrambackend.Api.FeedInfoApi;
import com.example.Instagrambackend.DTO.CommentDto;
import com.example.Instagrambackend.DTO.LikeDto;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Service.FeedInfoService;
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
