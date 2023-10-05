package com.example.Instagrambackend.Controller;
import com.example.Instagrambackend.Service.Impl.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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