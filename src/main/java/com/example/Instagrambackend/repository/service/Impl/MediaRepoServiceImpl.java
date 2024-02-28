package com.example.Instagrambackend.repository.service.Impl;

import com.example.Instagrambackend.model.Media;
import com.example.Instagrambackend.repository.MediaRepository;
import com.example.Instagrambackend.repository.service.MediaRepoService;
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
