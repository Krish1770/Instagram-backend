package com.example.Instagrambackend.Api;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface RelationApi {


    @PostMapping("/actionRequest")
     ResponseEntity<ResponseDTO> followRequest(@RequestBody SenderIdReceiverDTO senderReceiverDTO);

    @PutMapping("/unFollowRequest")
    public  ResponseEntity<ResponseDTO> unFollow(@RequestBody SenderIdReceiverDTO senderReceiverDTO);

    @PostMapping("/FriendRequest")
    public  ResponseEntity<ResponseDTO> FriendRequest(@RequestBody SenderIdReceiverDTO senderReceiverDTO);


    @GetMapping("/FriendList/{userId}")
    public ResponseEntity<ResponseDTO>friendsList(@PathVariable Long userId);

    @GetMapping("/FollowerList/{userId}")
    public ResponseEntity<ResponseDTO>followersList(@PathVariable Long userId);

}
