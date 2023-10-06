package com.example.Instagrambackend.Repository.Service.Impl;

import com.example.Instagrambackend.Model.Media;
import com.example.Instagrambackend.Repository.MediaRepository;
import com.example.Instagrambackend.Repository.Service.MediaRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaRepoServiceImpl implements MediaRepoService {
    @Autowired
    private MediaRepository mediaRepository;
    @Override
    public Media save(Media media) {
    return mediaRepository.save(media);

    }
}
