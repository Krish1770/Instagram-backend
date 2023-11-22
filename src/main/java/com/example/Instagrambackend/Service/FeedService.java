package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.DTO.FeedDTO;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.FeedView;
//import com.example.Instagrambackend.Model.Feed_View;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FeedService {

    public boolean isValidUser(Long userId);

    public ResponseEntity<ResponseDTO> mediaUploadRequest(MultipartFile file, FeedDTO feedDTO) throws IOException;

    public ResponseEntity<ResponseDTO> FeedArchiving(Boolean ArchiveFlag,Long feedId);

    public ResponseEntity<ResponseDTO> getPublicFeed( Long user);

    public ResponseEntity<ResponseDTO> getPrivateFeed( Long user);

    List<FeedView> display();
}
