package com.example.Instagrambackend.service;

import com.example.Instagrambackend.dto.FeedDTO;
import com.example.Instagrambackend.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FeedService {

    public boolean isValidUser(Long userId);

    public ResponseEntity<ResponseDTO> mediaUploadRequest(MultipartFile file, FeedDTO feedDTO) throws IOException;

    public ResponseEntity<ResponseDTO> FeedArchiving(Boolean ArchiveFlag, Long feedId);

    public ResponseEntity<ResponseDTO> getPublicFeed(Long user);

    public ResponseEntity<ResponseDTO> getPrivateFeed(Long user);

    ResponseEntity<ResponseDTO> display();
}
