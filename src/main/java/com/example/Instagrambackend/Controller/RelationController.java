package com.example.Instagrambackend.Controller;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import com.example.Instagrambackend.Model.Relation;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/user")
public class RelationController {

    @Autowired
    private RelationService relationService;


    @PostMapping("/followRequest")
    public ResponseEntity<ResponseDTO> followRequest(@RequestBody SenderIdReceiverDTO senderReceiverDTO)
    {
        String result=relationService.isUsersValid(senderReceiverDTO.getSender(),senderReceiverDTO.getReceiver());
        if(relationService.isUserValid(senderReceiverDTO.getReceiver())) {
            Boolean isReceiverPublic = relationService.isReceiverPublic(senderReceiverDTO.getReceiver());
            if(!isReceiverPublic)
            {

            }
        }
             if(!result.equals(""))
             {
               return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,result+"not found",""));
           }
        return relationService.followRequest(senderReceiverDTO);


//        System.out.println(senderReceiverDTO.getSender()+" "+senderReceiverDTO.getReceiver());



    }

    @PutMapping("/unFollowRequest")
    public  ResponseEntity<ResponseDTO> unFollow(@RequestBody SenderIdReceiverDTO senderReceiverDTO)
    {
        String result=relationService.isUsersValid(senderReceiverDTO.getSender(),senderReceiverDTO.getReceiver());
        if(!result.equals(""))
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,result+"not found",""));
        }
        return relationService.unFollow(senderReceiverDTO);

    }

    @PostMapping("/FriendRequest/{request}")
    public  ResponseEntity<ResponseDTO> FriendRequest(@PathVariable(value = "request") String request,@RequestBody SenderIdReceiverDTO senderReceiverDTO)
    {
        senderReceiverDTO.setAction("friend");
        String result=relationService.isUsersValid(senderReceiverDTO.getSender(),senderReceiverDTO.getReceiver());
        if(!result.equals(""))
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,result+"not found",""));
        }
      senderReceiverDTO.setAction("follow");
        if(request.equals("request"))  //requesting
        {

            return relationService.actionRequest(senderReceiverDTO);
        }

        else if(request.equals("accept"))  //accepting the request
            return relationService.actionAccept(senderReceiverDTO);

        else if(request.equals("deny")) //denying the request
            return relationService.actionDenied(senderReceiverDTO);

        else return relationService.actionRemove(senderReceiverDTO);
    }

    @GetMapping("/FriendList/{userId}")
    public ResponseEntity<ResponseDTO>friendsList(@PathVariable  Long userId)
    {
        if(relationService.isUserValid(userId)) {
            return relationService.friendsList(userId);
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK," user not found",""));

    }

    @GetMapping("/FollowerList/{userId}")
    public ResponseEntity<ResponseDTO>followersList(@PathVariable Long userId)
    {
        if(relationService.isUserValid(userId)) {
            return relationService.followersList(userId);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK," user not found",""));
    }

}
