package com.example.Instagrambackend.api;


import com.example.Instagrambackend.dto.CommentDto;
import com.example.Instagrambackend.dto.LikeDto;
import com.example.Instagrambackend.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("FeedInfo")
public interface FeedInfoApi {

    @PostMapping("/comments")
    ResponseEntity<ResponseDTO> addComments(@RequestBody CommentDto commentDto);

    @PostMapping("/likes")
    ResponseEntity<ResponseDTO> manageLikes(@RequestBody LikeDto likeDto);

}
