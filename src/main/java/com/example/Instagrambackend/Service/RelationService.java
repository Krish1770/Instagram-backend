package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import com.example.Instagrambackend.Model.Relation;
import com.example.Instagrambackend.Repository.RelationTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RelationService {
    @Autowired
    private RelationTableRepository relationrepository ;

//    public RelationService(RelationTableRepository relationrepository) {
//        this.relationrepository = relationrepository;
//    }

    public ResponseEntity<Relation> addFollowing( SenderIdReceiverDTO senderReceiverDTO) {

        System.out.println(senderReceiverDTO.getSender()+"  "+senderReceiverDTO.getReceiver());
        Relation tempRelation ;
        tempRelation=relationrepository.findBySenderAndReceiver(senderReceiverDTO.getSender(), senderReceiverDTO.getReceiver());
        System.out.println(tempRelation);
     Relation tempRelation1=new Relation();
        if(tempRelation==null)
        {
            tempRelation1.setUserKey(senderReceiverDTO.getSender(),senderReceiverDTO.getReceiver());
            tempRelation1.setStatus("none");
            tempRelation1.setFollowing(true);

            relationrepository.save(tempRelation1);

            return ResponseEntity.status(HttpStatus.OK).body(new Relation(HttpStatus.OK,(senderReceiverDTO.getSender() +
                    "is following "+senderReceiverDTO.getReceiver()),""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new Relation(HttpStatus.NOT_FOUND,(senderReceiverDTO.getSender() +
                "is following "+senderReceiverDTO.getReceiver()),""));
    }
}
