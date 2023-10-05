package com.example.Instagrambackend.Controller;

import com.example.Instagrambackend.Api.FeedControllerApi;
import com.example.Instagrambackend.DTO.FeedDTO;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Service.FeedService;
import com.example.Instagrambackend.Service.Impl.FeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
public class FeedController implements FeedControllerApi {

    @Autowired
    private FeedService feedService;



    //whether video or image
    public ResponseEntity<ResponseDTO> mediaUpload( MultipartFile file,  Map<String,String> header) throws Exception {
        System.out.println(header);

        if(feedService.isValidUser(Long.parseLong(header.get("user")))) {
            FeedDTO feedDTO = new FeedDTO();
            feedDTO.setPrivacyType(header.get("privacytype"));
            feedDTO.setType(header.get("type"));
            feedDTO.setUser(Long.parseLong(header.get("user")));
//        System.out.println();
            return feedService.mediaUploadRequest(file, feedDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"user not found",""));
    }

     public ResponseEntity<ResponseDTO> FeedArchiving( Boolean ArchiveFlag,  Long feedId)
    {
        return  feedService.FeedArchiving(ArchiveFlag,feedId);
    }


    public ResponseEntity<ResponseDTO> getFeed( Map<String,String>feedDetails) throws IOException {
        System.out.println("dsfgsssdvb");
        Long userId=Long.parseLong(feedDetails.get("userId"));
        String feedType=feedDetails.get("feedType");
        if(!feedService.isValidUser(userId))
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"user not found",""));

        }
        if(feedType.equals("public"))
         return feedService.getPublicFeed(userId);

        return feedService.getPrivateFeed(userId);
    }



}
