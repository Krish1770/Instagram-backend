package com.example.Instagrambackend.Service.Impl;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import com.example.Instagrambackend.Model.Relation;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.RelationRepository;
import com.example.Instagrambackend.Repository.UserRepository;
import com.example.Instagrambackend.Service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    private UserRepository userRepository;


    public String isUsersValid(Long userId1, Long userId2) {

        boolean sender = userRepository.findById(userId1).isPresent();
        boolean receiver = userRepository.findById(userId2).isPresent();
        String temp = "";
        if (!sender) {
            temp += userId1;

        }
        if(!receiver)
        {
            temp+="";
            temp+=userId2;
        }
        if(!temp.isEmpty())
            return temp;
        return "";
    }

    public boolean isUserValid(Long userId) {
        return userRepository.findById(userId).isPresent();
    }


    public ResponseEntity<ResponseDTO> followRequest(SenderIdReceiverDTO senderReceiverDTO) {

        System.out.println(senderReceiverDTO.getSender() + "  " + senderReceiverDTO.getReceiver());

        Optional<Relation> byUserKeySenderUserIdAndUserKeyReceiverUserId = relationRepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(senderReceiverDTO.getSender(), senderReceiverDTO.getReceiver());

        if (byUserKeySenderUserIdAndUserKeyReceiverUserId.isPresent() && !(byUserKeySenderUserIdAndUserKeyReceiverUserId.get().getFollowing())) {
            byUserKeySenderUserIdAndUserKeyReceiverUserId.get().setFollowing(true);
            byUserKeySenderUserIdAndUserKeyReceiverUserId.get().setFollowingRequest("accepted");
            relationRepository.save(byUserKeySenderUserIdAndUserKeyReceiverUserId.get());
            System.out.println("doneeeeeeeeeeee");
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, (senderReceiverDTO.getSender() +
                    "is folllllllowing " + senderReceiverDTO.getReceiver()), ""));

        }


        if (byUserKeySenderUserIdAndUserKeyReceiverUserId.isEmpty()) {
            Relation tempRelation = new Relation();
            tempRelation.setUserKey(userRepository.findById(senderReceiverDTO.getSender()).get(), userRepository.findById(senderReceiverDTO.getReceiver()).get());
//            tempRelation.setStatus("none");
            tempRelation.setFollowing(true);

            Relation save = relationRepository.save(tempRelation);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, (senderReceiverDTO.getSender() +
                    "is  following " + senderReceiverDTO.getReceiver()), save));

        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, (senderReceiverDTO.getSender() +
                "is already following " + senderReceiverDTO.getReceiver()), ""));
    }

    public ResponseEntity<ResponseDTO> unFollow(SenderIdReceiverDTO senderReceiverDTO) {

        Optional<Relation> byUserKeySenderUserIdAndUserKeyReceiverUserId = relationRepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(senderReceiverDTO.getSender(), senderReceiverDTO.getReceiver());

        if (!byUserKeySenderUserIdAndUserKeyReceiverUserId.isEmpty()) {
            Relation tempRelation = new Relation();
            tempRelation.setUserKey(userRepository.findById(senderReceiverDTO.getSender()).get(), userRepository.findById(senderReceiverDTO.getReceiver()).get());
            tempRelation.setFollowing(false);

            Relation save = relationRepository.save(tempRelation);

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, (senderReceiverDTO.getSender() +
                    "unfollowed " + senderReceiverDTO.getReceiver()), save));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND, (senderReceiverDTO.getSender() +
                "is  already not  following " + senderReceiverDTO.getReceiver()), ""));
    }

    public ResponseEntity<ResponseDTO> actionRequest(SenderIdReceiverDTO senderReceiverDTO) {
        Optional<Relation> tempRelation = relationRepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(senderReceiverDTO.getSender(), senderReceiverDTO.getReceiver());
  String action=senderReceiverDTO.getAction();
        System.out.println("requestService");
        if (tempRelation == null) {
            tempRelation = relationRepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(senderReceiverDTO.getReceiver(), senderReceiverDTO.getSender());

        }
        if (tempRelation.isPresent()) {
//
            if((action.equals("follow") && (tempRelation.get().getFollowingRequest()!=null && tempRelation.get().getFollowingRequest().equals("requested")))
            || (action.equals("friend") && (tempRelation.get().getStatus()!=null&&(tempRelation.get().getStatus()).equals("requested"))))
            {
              return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, " request " +
                            "already sent", senderReceiverDTO));

                } else if ((action.equals("follow") && (tempRelation.get().getFollowingRequest()!=null && tempRelation.get().getFollowingRequest().equals("accepted")))

                    || (action.equals("friend") && (tempRelation.get().getStatus()!=null&&(tempRelation.get().getStatus()).equals("accepted"))))
            {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, " already a" +
                            action, senderReceiverDTO));
                } else {
            System.out.println("relation present");
            if (action.equals("friend"))
                tempRelation.get().setStatus("requested");

            else
                tempRelation.get().setFollowingRequest("accepted");
            Relation newRelation = tempRelation.get();
            relationRepository.save(newRelation);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, " request" +

                    "sent", newRelation));
        }

            }
//            catch (Exception e) {

//              return null;
//            }


         else {
            Relation newRelation = new Relation();

            newRelation.setUserKey(userRepository.findById(senderReceiverDTO.getSender()).get()
                    , userRepository.findById(senderReceiverDTO.getReceiver()).get());

            if(action.equals("friend"))
             newRelation.setStatus("requested");
            else
                newRelation.setFollowingRequest("requested");
            relationRepository.save(newRelation);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, " request" +
                    "sent", newRelation));

        }
    }

    public ResponseEntity<ResponseDTO> actionAccept(SenderIdReceiverDTO senderReceiverDTO) {
        Optional<Relation> tempRelation = relationRepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(senderReceiverDTO.getSender(), senderReceiverDTO.getReceiver());

         int resultFlag=0;
        String action=senderReceiverDTO.getAction();
        System.out.println(action);
        if (tempRelation.isPresent()) {

                 if((action.equals("follow") && (tempRelation.get().getFollowingRequest()!=null && tempRelation.get().getFollowingRequest().equals("requested"))))
                    {
                        tempRelation.get().setFollowingRequest("accepted");
                        Relation newRelation=tempRelation.get();
                        relationRepository.save(newRelation);
                        resultFlag=1;
                    }
            else if(action.equals("friend") && (tempRelation.get().getStatus()!=null&&(tempRelation.get().getStatus()).equals("requested")))
            {

                tempRelation.get().setStatus("accepted");
                tempRelation.get().setFollowing(true);
                resultFlag=1;

                }
            else if((action.equals("follow") && (tempRelation.get().getFollowingRequest()!=null && tempRelation.get().getFollowingRequest().equals("accepted")))
            || (action.equals("friend") && (tempRelation.get().getStatus()!=null&&(tempRelation.get().getStatus()).equals("accepted"))))
            {
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, " already a" +
                            action, senderReceiverDTO));
                } else {

                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, action+" not" +
                            "sent", ""));

                }

            if(resultFlag==1)
            {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, action+" request " +
                        "accepted", senderReceiverDTO));
            }


        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(HttpStatus.NOT_FOUND, "Relation not found"
                , senderReceiverDTO));
    }

    public ResponseEntity<ResponseDTO> actionDenied(SenderIdReceiverDTO senderReceiverDTO) {

        Optional<Relation> tempRelation = relationRepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(senderReceiverDTO.getSender(), senderReceiverDTO.getReceiver());
  String action=senderReceiverDTO.getAction();

  int resultFlag=0;
        if (tempRelation.isPresent()) {
//
            if((action.equals("follow") && (tempRelation.get().getFollowingRequest()!=null && tempRelation.get().getFollowingRequest().equals("requested"))))
            {
                tempRelation.get().setFollowingRequest("denied");
                resultFlag=1;

            }
            else if(action.equals("friend") && (tempRelation.get().getStatus()!=null&&(tempRelation.get().getStatus()).equals("requested")))
            {

                tempRelation.get().setStatus("denied");

                Relation newRelation=tempRelation.get();
                relationRepository.save(newRelation);
                resultFlag=1;

            }

              else if((action.equals("follow") && (tempRelation.get().getFollowingRequest()!=null && tempRelation.get().getFollowingRequest().equals("accepted")))
                    || (action.equals("friend") && (tempRelation.get().getStatus()!=null&&(tempRelation.get().getStatus()).equals("accepted"))))
            {
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, " already a" +
                            action, senderReceiverDTO));
                } else {

                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "  already they are not a friends"
                            , ""));

                }
//



        }
        if(resultFlag==1)
           return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, action+" request " +
                "denied", senderReceiverDTO));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "no request is sent to deny"
                , ""));
    }

    public ResponseEntity<ResponseDTO> actionRemove(SenderIdReceiverDTO senderReceiverDTO) {
        Optional<Relation> tempRelation = relationRepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(senderReceiverDTO.getSender(), senderReceiverDTO.getReceiver());

        String action=senderReceiverDTO.getAction();


        if (tempRelation.isPresent()) {

                 if((action.equals("follow") && (tempRelation.get().getFollowingRequest()!=null && tempRelation.get().getFollowingRequest().equals("requested")))
                    || (action.equals("friend") && (tempRelation.get().getStatus()!=null&&(tempRelation.get().getStatus()).equals("requested")))) {
                     return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "relation doesn't exist " +
                             "to remove ", senderReceiverDTO));
                 }

                else if((action.equals("follow") && (tempRelation.get().getFollowingRequest()!=null && tempRelation.get().getFollowingRequest().equals("accepted"))))
                    {
                        tempRelation.get().setFollowingRequest("removed");
                        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "removed from follow"
                                , senderReceiverDTO));
                    }
            else if(action.equals("friend") && (tempRelation.get().getStatus()!=null&&(tempRelation.get().getStatus()).equals("removed")))
            {
                    tempRelation.get().setStatus("removed");
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "removed from friend's" +
                            "list", senderReceiverDTO));
                } else {

                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "  already not a relation"
                            , ""));

                }

        }

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "  already not a relation"
                , ""));


    }

    public ResponseEntity<ResponseDTO> friendsList(Long userId) {
        User tempUser = userRepository.findById(userId).get();

        if (tempUser != null) {
            List<Relation> friendList = relationRepository.findByUserKeySenderUserIdOrUserKeyReceiverUserIdAndStatus(userId, userId, "accepted").get();

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "friend List returned", friendList));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND, "User has no friends", ""));
    }

    public ResponseEntity<ResponseDTO> followersList(Long userId) {

        User tempUser = userRepository.findById(userId).get();

        if (tempUser != null) {
            List<Relation> followersList = relationRepository.findByUserKeyReceiverUserIdAndFollowing(userId, true).get();

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "follow List returned", followersList));

        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND, "User has no followers", ""));

    }

    public boolean isReceiverPublic(Long userId)
    {
        User user=userRepository.findById(userId).get();
        return user.getAccountType().equals("public");
    }
}



