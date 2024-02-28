package com.example.Instagrambackend.api;

import com.example.Instagrambackend.dto.ResponseDTO;
//import com.example.Instagrambackend.Model.Feed_View;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FeedApi {

    @PostMapping("/upload/file")
    public ResponseEntity<ResponseDTO> mediaUpload(@RequestBody MultipartFile file, @RequestHeader Map<String,String> header) throws Exception;

    @PutMapping(value = "/upload/{feedId}/find/{ArchiveFlag}")
    public ResponseEntity<ResponseDTO> FeedArchiving(@PathVariable Boolean ArchiveFlag, @PathVariable Long feedId);

    @GetMapping("/view/{userId}/{feedType}")
    @CachePut( value = "#userId+'_'+#feedType")
    public String getFeed(@PathVariable Long userId,@PathVariable String feedType);
    //just for learning view concept

//    public String getFeed(@PathVariable Map<String,String>feedDetails) throws IOException;

    @GetMapping("/feedDetails/{userId}")
    public  ResponseEntity<ResponseDTO> display();
}

