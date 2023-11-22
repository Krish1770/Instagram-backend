package com.example.Instagrambackend.Controller;

import com.example.Instagrambackend.Api.FeedControllerApi;
import com.example.Instagrambackend.DTO.FeedDTO;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.Feed;
import com.example.Instagrambackend.Model.FeedView;
//import com.example.Instagrambackend.Model.Feed_View;
import com.example.Instagrambackend.Service.FeedService;
import com.example.Instagrambackend.Service.Impl.FeedServiceImpl;
import org.bson.json.JsonObject;
import org.bson.json.JsonWriter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
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
             ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"user not found",""));
         return "";
        }
        if(feedType.equals("public")) {

   ResponseDTO object=feedService.getPublicFeed(userId).getBody();

            JSONObject jsonObject1=new JSONObject(object);

            String string = jsonObject1.toString();

            return string;
        }
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
    public List<FeedView> display() {
        return feedService.display();
    }


}
