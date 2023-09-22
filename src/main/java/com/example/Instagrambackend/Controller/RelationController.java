package com.example.Instagrambackend.Controller;

import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import com.example.Instagrambackend.Model.Relation;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user/")
public class RelationController {

    @Autowired
    private RelationService relationService;


    @PostMapping("addFollowing")
    public ResponseEntity<Relation> addFollowing(@RequestBody SenderIdReceiverDTO senderReceiverDTO)
    {
        System.out.println(senderReceiverDTO.getSender()+" "+senderReceiverDTO.getReceiver());
        return relationService.addFollowing(senderReceiverDTO);
    }

}
