package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import com.example.Instagrambackend.Model.Relation;
import com.example.Instagrambackend.Repository.RelationTableRepository;
import com.example.Instagrambackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelationService {
    @Autowired
    private RelationTableRepository relationrepository ;
    @Autowired
    private UserRepository userRepository;

//    public RelationService(RelationTableRepository relationrepository) {
//        this.relationrepository = relationrepository;
//    }

    public ResponseEntity<Relation> addFollowing( SenderIdReceiverDTO senderReceiverDTO) {

        System.out.println(senderReceiverDTO.getSender()+"  "+senderReceiverDTO.getReceiver());

        Optional<Relation> byUserKeySenderUserIdAndUserKeyReceiverUserId = relationrepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(senderReceiverDTO.getSender(), senderReceiverDTO.getReceiver());

        if(byUserKeySenderUserIdAndUserKeyReceiverUserId.isEmpty())
        {
            Relation tempRelation = new Relation();
            tempRelation.setUserKey(userRepository.findById(senderReceiverDTO.getSender()).get(),userRepository.findById(senderReceiverDTO.getReceiver()).get());
            tempRelation.setStatus("none");
            tempRelation.setFollowing(true);

            Relation save = relationrepository.save(tempRelation);

            return ResponseEntity.status(HttpStatus.OK).body(save);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new Relation(HttpStatus.NOT_FOUND,(senderReceiverDTO.getSender() +
                "is following "+senderReceiverDTO.getReceiver()),""));
    }
}
