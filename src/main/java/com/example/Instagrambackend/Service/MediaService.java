package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.Media;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.MediaRepository;
import com.example.Instagrambackend.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLOutput;

@Service
public class MediaService {


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

