package com.example.Instagrambackend.Api;

import com.example.Instagrambackend.DTO.ResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface FeedControllerApi {

    @PostMapping("/upload/file")
    public ResponseEntity<ResponseDTO> mediaUpload(@RequestBody MultipartFile file, @RequestHeader Map<String,String> header) throws Exception;

    @PutMapping(value = "/upload/{feedId}/{ArchiveFlag}")
    public ResponseEntity<ResponseDTO> FeedArchiving(@PathVariable Boolean ArchiveFlag, @PathVariable Long feedId);

    @GetMapping("/view/{userId}/{feedType}")
    public ResponseEntity<ResponseDTO> getFeed(@PathVariable Map<String,String>feedDetails) throws IOException;

}

