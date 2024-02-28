package com.example.Instagrambackend.service.impl;

import com.example.Instagrambackend.dto.CommentDto;
import com.example.Instagrambackend.dto.LikeDto;
import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.model.*;
import com.example.Instagrambackend.mongoQuery.MongoQueries;
import com.example.Instagrambackend.repository.FeedInfoRepository;
import com.example.Instagrambackend.repository.service.FeedInfoRepoService;
import com.example.Instagrambackend.service.FeedInfoService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FeedInfoServiceImpl implements FeedInfoService {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private FeedInfoRepoService feedInfoRepoService;

    @Autowired
    private FeedInfoRepository feedInfoRepository;


    @Autowired
    private MongoQueries mongoQueries;


    @Override
    public ResponseEntity<ResponseDTO> addComments(CommentDto commentDto) {


        Optional<FeedInfo> tempFeedInfo = feedInfoRepoService.findByFeedId(commentDto.getFeedId());

        FeedInfo feedInfo = null;
        feedInfo = tempFeedInfo.orElseGet(FeedInfo::new);

        List<CommentInfo> commentInfoList = null;

        if (tempFeedInfo.isEmpty()) {
            feedInfo = new FeedInfo();
            feedInfo.setFeedId(commentDto.getFeedId());
            List<User> list = new ArrayList<>();
            Likes likes = new Likes();
            likes.setLikedUsers(list);

            feedInfo.setFeedLikes(likes);
            commentInfoList = new ArrayList<>();
            List<User> list1 = new ArrayList<>();
            Likes likes1 = new Likes();
            likes1.setLikedUsers(list1);

        } else {
            commentInfoList = tempFeedInfo.get().getCommentInfo();

        }
        CommentReply commentInfo = new CommentReply();
        if (commentDto.getIsReply()) {
            commentInfo.setReceiverCommentId(commentDto.getReceiverCommentId());
            commentInfo.setReceiver(userServiceImpl.isUserValid(commentDto.getReceiver()).get());
        }
        commentInfo.setComment(commentDto.getMessage());
        commentInfo.setLikes(new Likes(new ArrayList<User>()));


        Optional<User> sender = userServiceImpl.isUserValid(commentDto.getSender());
        if (sender.isPresent()) {

            commentInfo.setSender(sender.get());
            commentInfo.setCreatedAt(new Date());
            commentInfo.setId(UUID.randomUUID().toString());
            commentInfoList.add(commentInfo);

            feedInfo.setCommentInfo(commentInfoList);

            feedInfoRepository.save(feedInfo);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(HttpStatus.NOT_FOUND, "sender not found", commentDto.getSender()));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "comment saved", feedInfo));
    }

    @Override
    public ResponseEntity<ResponseDTO> manageLikes(LikeDto likeDto) {


        Optional<FeedInfo> feedInfo = feedInfoRepository.findByFeedId(likeDto.getFeedId());
        Likes likes = null;

        User newUser = userServiceImpl.isUserValid(likeDto.getUserId()).get();

        UpdateResult updateResult = mongoQueries.updateCommentLikes(likeDto.getFeedId(), likeDto.getCommentId(), newUser);
//        if(feedInfo.isPresent()) {
//            if (!likeDto.getIsCommentLike()) {
//                likes = feedInfo.get().getFeedLikes();
//
//                System.out.println("likes added");
//                likes.getLikedUsers().add(userServiceImpl.isUserValid(likeDto.getUserId()).get());
//                feedInfo.get().setFeedLikes(likes);
//            }
//            else
//
//            {
//
//                    Optional<CommentInfo> commentInfo1=feedInfoRepoService.findByFeedIdAndCommentInfoId(likeDto.getFeedId(),likeDto.getCommentId());
//                   CommentInfo commentInfo2=commentInfo1.get();
//                    int index= feedInfo.get().getCommentInfo().indexOf(commentInfo2);
//                  commentInfo1.get().getLikes().getLikedUsers().add(userServiceImpl.isUserValid(likeDto.getUserId()).get());
//                    System.out.println("comment liked");
//
//                    feedInfo.get().getCommentInfo().add(index,commentInfo1.get());
//
//
//
//            }
//
//            feedInfoRepository.save(feedInfo.get());
//        }
//
//        else
//        {
//
//            FeedInfo feedInfo1=new FeedInfo();
//            Likes likes1 = new Likes(new ArrayList<>());
//            likes1.getLikedUsers().add((userServiceImpl.isUserValid(likeDto.getUserId()).get())); //liked list created either for feeds or comments
//
//            if(likeDto.getIsFeedLike() && !likeDto.getIsCommentLike()) {
//
//                feedInfo1.setFeedId(likeDto.getFeedId());
//
//                feedInfo1.setFeedLikes(likes1);
//            }
//            else if(likeDto.getIsCommentLike())
//            {
//
//
//                ArrayList<CommentInfo> commentInfoList=new ArrayList<>();
//
//                CommentInfo commentInfo=new CommentInfo();
//             commentInfoList.add(commentInfo);
//
//                commentInfo.setLikes(likes1);
//
//                feedInfo1.setCommentInfo(commentInfoList);
//            }
//            feedInfoRepository.save(feedInfo1);
//
//            System.out.println("new feed created and saved");
//        }
        System.out.println(updateResult);

        return null;
    }
}
