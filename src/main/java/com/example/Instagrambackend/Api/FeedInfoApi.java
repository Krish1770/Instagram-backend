package com.example.Instagrambackend.Api;


import com.example.Instagrambackend.DTO.CommentDto;
import com.example.Instagrambackend.DTO.LikeDto;
import com.example.Instagrambackend.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
