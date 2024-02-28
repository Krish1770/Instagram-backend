package com.example.Instagrambackend.service.impl;

import com.example.Instagrambackend.repository.MediaRepository;
import com.example.Instagrambackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaServiceImpl {


    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private UserRepository userRepository;
//    public ResponseEntity<ResponseDTO> mediaUploadRequest(User user, String type, MultipartFile file) throws  Exception{
//
//        Media media =new Media();
//        media.setName(file.getOriginalFilename());
//        media.setData(file.getBytes());
//        System.out.println(type);
//
//        media.setType(type);
//       User newUser=userRepository.findById(user.getUserId()).get();
//       media.setFeedId();
//        mediaRepository.save(media);
//
//
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"media sent",""));
//
//    }

}

