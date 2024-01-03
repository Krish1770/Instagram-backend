package com.example.Instagrambackend.Service.Impl;

import com.example.Instagrambackend.DTO.FeedDTO;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.*;
import com.example.Instagrambackend.Repository.Service.*;
import com.example.Instagrambackend.Service.FeedService;
import jakarta.transaction.Transactional;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private FeedViewRepoService feedViewRepoService;
    @Autowired
    private FeedRepoService feedRepoService;

    @Autowired
    private MediaRepoService mediaRepoService;
    @Autowired
    private UserRepoService userRepoService;

   @Autowired
   private RelationRepoService relationRepoService;


    public boolean isValidUser(Long userId) {
        return userRepoService.findById(userId).isPresent();
    }


    @Transactional
    public ResponseEntity<ResponseDTO> mediaUploadRequest(MultipartFile file,FeedDTO feedDTO) throws IOException {

        System.out.println(file);
        System.out.println("feedDTO"+feedDTO);
        Feed newFeed=new Feed();

//        Feed newFeed=null;
        newFeed.setArchived(false);
        newFeed.setUploadDate(new Date());

        newFeed.setPrivacyType(feedDTO.getPrivacyType());


        Media media =new Media();
        media.setId(2L);
        media.setName(file.getOriginalFilename());
        media.setData(file.getBytes());
        media.setType(file.getContentType());

        media.setType(feedDTO.getType());
          Media media1=mediaRepoService.save(media);


        System.out.println(media1);
        applicationEventPublisher.publishEvent( new CustomSpringEvent(this));
        newFeed.setMedia(media1);

        User newUser=userRepoService.findById(feedDTO.getUser()).get();
        newFeed.setUserId(newUser);
//        newFeed=null;
        Feed feed=feedRepoService.save(newFeed);
        System.out.println(media.toString());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"media has been posted",feed));

    }

    public ResponseEntity<ResponseDTO> FeedArchiving(Boolean ArchiveFlag,Long feedId) {
  Feed newFeed=feedRepoService.findById(feedId).get();

  if(ArchiveFlag!=newFeed.isArchived()) {
      newFeed.setArchived(ArchiveFlag);
      feedRepoService.save(newFeed);
      if(ArchiveFlag)
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"post has been archived",""));
    else
          return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"post has been archived",""));

  }

  else
  {
      if(ArchiveFlag)
          return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"post is already archived",""));
      else
          return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"post is already unarchived",""));
  }


    }


    public ResponseEntity<ResponseDTO> getPublicFeed( Long user) {
        User newUser = new User();
        newUser.setUserId(user);

        List<Feed> publicFeeds = feedRepoService.findAllByPrivacyTypeAndIsArchivedAndAndUserIdAccountTypeOrderByUploadDate("public",false,"public");
        System.out.println("cdsgs");
        for(Feed i:publicFeeds)
            System.out.println(i.getFeedId());

        List<ByteArrayInputStream> imageBytesList = new ArrayList<>();
        List<File> files = new ArrayList<>();


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"feeds retrieved Successfully",publicFeeds));

    }

    public ResponseEntity<ResponseDTO> getPrivateFeed(Long userId) {

        User newUser=new User();
        newUser.setUserId(userId);

      Optional <List<Relation>> friendsAndFollowing=relationRepoService.findAllByUserKeySenderUserIdAndFollowingOrStatus
                (userId,true,"accepted");

//      List<Optional<Relation>> privateFeedsOfTheUser=new ArrayList<>();
        System.out.println(friendsAndFollowing);

        List<Feed> feed=new ArrayList<>();


        for(Relation i:friendsAndFollowing.get()) {
            System.out.println(i.getUserKey().getReceiver());


                 Long receiverId = i.getUserKey().getReceiver().getUserId();
                 User tempUser = new User();
                 System.out.println(receiverId);
                 tempUser.setUserId(receiverId);

                 List<Feed> tempfeed = feedRepoService.findAllByUserIdUserIdAndIsArchived(receiverId,false);

                 System.out.println(tempfeed.isEmpty());
                 feed.addAll(tempfeed);

        }

         return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"feeds retrieved Successfully",feed));

    }

    @Override
    public ResponseEntity<ResponseDTO> display() {


        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"all feeds",""));
    }

}
