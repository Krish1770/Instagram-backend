package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface RelationService {

     String isUsersValid(Long userId1, Long userId2);

     boolean isUserValid(Long userId);

     ResponseEntity<ResponseDTO> followRequest(SenderIdReceiverDTO senderReceiverDTO);

     ResponseEntity<ResponseDTO> unFollow(SenderIdReceiverDTO senderReceiverDTO);

     ResponseEntity<ResponseDTO> actionRequest(SenderIdReceiverDTO senderReceiverDTO) ;

     ResponseEntity<ResponseDTO> actionAccept(SenderIdReceiverDTO senderReceiverDTO);

     ResponseEntity<ResponseDTO> actionDenied(SenderIdReceiverDTO senderReceiverDTO);

     ResponseEntity<ResponseDTO> actionRemove(SenderIdReceiverDTO senderReceiverDTO);

     ResponseEntity<ResponseDTO> friendsList(Long userId);

     ResponseEntity<ResponseDTO> followersList(Long userId) ;

     boolean isReceiverPublic(Long userId);
    }
