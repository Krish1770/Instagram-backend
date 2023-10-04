package com.example.Instagrambackend.Controller;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Media")
public class MediaController {

    @Autowired
    private MediaService mediaService;


//    @PostMapping("/upload/{userId}/{Type}")  //whether video or image
//    public ResponseEntity <ResponseDTO> mediaUpload(@PathVariable User userId, @PathVariable String Type, @RequestBody MultipartFile file) throws Exception {
//       return mediaService.mediaUploadRequest(userId,Type,file );
//    }
}