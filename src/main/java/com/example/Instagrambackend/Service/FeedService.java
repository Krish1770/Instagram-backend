package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.DTO.FeedDTO;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.Feed;
import com.example.Instagrambackend.Model.Media;
import com.example.Instagrambackend.Model.Relation;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.FeedRepository;
import com.example.Instagrambackend.Repository.MediaRepository;
import com.example.Instagrambackend.Repository.RelationRepository;
import com.example.Instagrambackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FeedService {

    @Autowired
    private FeedRepository feedRepository;

    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private UserRepository userRepository;

   @Autowired
   private RelationRepository relationRepository;
    public boolean isValidUser(Long userId) {
        return userRepository.findById(userId).isPresent();
    }
    public ResponseEntity<ResponseDTO> mediaUploadRequest(MultipartFile file,FeedDTO feedDTO) throws  Exception{

        Feed newFeed=new Feed();
        newFeed.setArchived(false);
        newFeed.setUploadDate(new Date());

        newFeed.setPrivacyType(feedDTO.getPrivacyType());


        Media media =new Media();
        media.setName(file.getOriginalFilename());
        media.setData(file.getBytes());

        media.setType(feedDTO.getType());
        mediaRepository.save(media);
        newFeed.setMedia(media);
        User newUser=userRepository.findById(feedDTO.getUser()).get();
        newFeed.setUserId(newUser);
        System.out.println(feedRepository.save(newFeed));



        System.out.println(media.toString());


        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"media has been posted",""));

    }

    public ResponseEntity<ResponseDTO> FeedArchiving(Boolean ArchiveFlag,Long feedId) {
  Feed newFeed=feedRepository.findById(feedId).get();

  if(ArchiveFlag!=newFeed.isArchived()) {
      newFeed.setArchived(ArchiveFlag);
      feedRepository.save(newFeed);
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


    public ResponseEntity<ResponseDTO> getPublicFeed( Long user) throws IOException {
        User newUser = new User();
        newUser.setUserId(user);

        List<Feed> publicFeeds = feedRepository.findAllByPrivacyTypeAndIsArchivedAndAndUserIdAccountTypeOrderByUploadDate("public",false,"public");
        


        List<ByteArrayInputStream> imageBytesList = new ArrayList<>();
        List<File> files = new ArrayList<>();





        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"feeds retrieved Successfully",publicFeeds));

    }

    public ResponseEntity<ResponseDTO> getPrivateFeed(Long userId) {

        User newUser=new User();
        newUser.setUserId(userId);

      Optional <List<Relation>> friendsAndFollowing=relationRepository.findAllByUserKeySenderUserIdAndFollowingOrStatus
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

                 List<Feed> tempfeed = feedRepository.findAllByUserIdUserIdAndIsArchived(receiverId,false);

                 System.out.println(tempfeed.isEmpty());
                 feed.addAll(tempfeed);





        }

         return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"feeds retrieved Successfully",feed));

    }

}
