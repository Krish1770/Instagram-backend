package com.example.Instagrambackend.controller;

import com.example.Instagrambackend.api.FeedApi;
import com.example.Instagrambackend.dto.FeedDTO;
import com.example.Instagrambackend.dto.ResponseDTO;
//import com.example.Instagrambackend.Model.Feed_View;
import com.example.Instagrambackend.service.FeedService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class FeedController implements FeedApi {


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

     public ResponseEntity<ResponseDTO> FeedArchiving(Boolean ArchiveFlag, Long feedId)
    {
        return  feedService.FeedArchiving(ArchiveFlag,feedId);
    }


    public String getFeed( Long userId,String feedType) {
        System.out.println("method call");
//        Long userId=Long.parseLong(feedDetails.get("userId"));
//        String feedType=feedDetails.get("feedType");
        if(!feedService.isValidUser(userId))
        {
         return "";
        }
        if(feedType.equals("public")) {

   ResponseDTO object=feedService.getPublicFeed(userId).getBody();

            JSONObject jsonObject1=new JSONObject(object);

            String string = jsonObject1.toString();

return  string;        }
        else if(feedType.equals("private"))
        {
            ResponseDTO object=feedService.getPrivateFeed(userId).getBody();

            JSONObject jsonObject=new JSONObject(object);

            String string=jsonObject.toString();

            return  string;
        }
        return "";
    }

    @Override
    public ResponseEntity<ResponseDTO> display() {
        return feedService.display();
    }


}