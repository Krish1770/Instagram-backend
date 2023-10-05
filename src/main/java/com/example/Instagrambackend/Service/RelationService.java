package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface RelationService {

    public String isUsersValid(Long userId1, Long userId2);

    public boolean isUserValid(Long userId);

    public ResponseEntity<ResponseDTO> followRequest(SenderIdReceiverDTO senderReceiverDTO);

    public ResponseEntity<ResponseDTO> unFollow(SenderIdReceiverDTO senderReceiverDTO);

    public ResponseEntity<ResponseDTO> actionRequest(SenderIdReceiverDTO senderReceiverDTO) ;

    public ResponseEntity<ResponseDTO> actionAccept(SenderIdReceiverDTO senderReceiverDTO);

    public ResponseEntity<ResponseDTO> actionDenied(SenderIdReceiverDTO senderReceiverDTO);

    public ResponseEntity<ResponseDTO> actionRemove(SenderIdReceiverDTO senderReceiverDTO);

    public ResponseEntity<ResponseDTO> friendsList(Long userId);

    public ResponseEntity<ResponseDTO> followersList(Long userId) ;

    public boolean isReceiverPublic(Long userId);
    }
