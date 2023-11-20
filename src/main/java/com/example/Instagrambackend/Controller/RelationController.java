package com.example.Instagrambackend.Controller;

import com.example.Instagrambackend.Api.RelationControllerApi;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import com.example.Instagrambackend.Service.Impl.RelationServiceImpl;
import com.example.Instagrambackend.Service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Digits;


@RestController
//@RequestMapping("/user")
public class RelationController implements RelationControllerApi {

    @Autowired
    private RelationService relationservice;




    public ResponseEntity<ResponseDTO> followRequest( SenderIdReceiverDTO senderReceiverDTO)
    {
        String result= relationservice.isUsersValid(senderReceiverDTO.getSender(),senderReceiverDTO.getReceiver());
        if(relationservice.isUserValid(senderReceiverDTO.getReceiver())) {
            Boolean isReceiverPublic = relationservice.isReceiverPublic(senderReceiverDTO.getReceiver());
            senderReceiverDTO.setAction("follow");
            System.out.println("asdfgh" + isReceiverPublic);
            String request = senderReceiverDTO.getRequest();
            System.out.println(result);
            if (result.equals("")) {
                if (!isReceiverPublic) {
                    if (request.equals("request")) {
                        System.out.println("werty");
                      return  relationservice.actionRequest(senderReceiverDTO);
                    } else if (request.equals("accept")) {
                       return relationservice.actionAccept(senderReceiverDTO);
                    } else if (request.equals("deny")) {
                     return   relationservice.actionDenied(senderReceiverDTO);

                    } else if (request.equals("remove")) {
                      return  relationservice.actionRemove(senderReceiverDTO);
                    } else {
                        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND, "request not found", ""));
                    }
                } else {
                    return relationservice.followRequest(senderReceiverDTO);
                }
            }
            else
             return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND,result+"not found",""));


        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND,"reciever not found",""));




//        System.out.println(senderReceiverDTO.getSender()+" "+senderReceiverDTO.getReceiver());



    }


    public  ResponseEntity<ResponseDTO> unFollow( SenderIdReceiverDTO senderReceiverDTO)
    {
        String result= relationservice.isUsersValid(senderReceiverDTO.getSender(),senderReceiverDTO.getReceiver());
        if(!result.equals(""))
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,result+"not found",""));
        }
        return relationservice.unFollow(senderReceiverDTO);

    }


    public  ResponseEntity<ResponseDTO> FriendRequest( SenderIdReceiverDTO senderReceiverDTO)
    {
        String request= senderReceiverDTO.getRequest();
        senderReceiverDTO.setAction("friend");
        String result= relationservice.isUsersValid(senderReceiverDTO.getSender(),senderReceiverDTO.getReceiver());
        if(!result.equals(""))
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,result+"not found",""));
        }
      senderReceiverDTO.setAction("friend");
        if(request.equals("request"))  //requesting
        {

            return relationservice.actionRequest(senderReceiverDTO);
        }

        else if(request.equals("accept"))  //accepting the request
            return relationservice.actionAccept(senderReceiverDTO);

        else if(request.equals("deny")) //denying the request
            return relationservice.actionDenied(senderReceiverDTO);

        else return relationservice.actionRemove(senderReceiverDTO);
    }


    public ResponseEntity<ResponseDTO>friendsList(  Long userId)
    {
        if(relationservice.isUserValid(userId)) {
            return relationservice.friendsList(userId);
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK," user not found",""));

    }

    public ResponseEntity<ResponseDTO>followersList( Long userId)
    {
        if(relationservice.isUserValid(userId)) {
            return relationservice.followersList(userId);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK," user not found",""));
    }
Digits
 }
