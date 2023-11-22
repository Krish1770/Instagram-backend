package com.example.Instagrambackend.Repository.Service.Impl;

import com.example.Instagrambackend.Model.Feed;
import com.example.Instagrambackend.Repository.FeedRepository;
import com.example.Instagrambackend.Repository.Service.FeedRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedRepoServiceImpl implements FeedRepoService {
    @Autowired
    FeedRepository feedRepository;

    @Override
    public List<Feed> findAllByUserIdUserIdAndIsArchived(Long userId, Boolean isArchived) {
        return feedRepository.findAllByUserIdUserIdAndIsArchived(userId, isArchived);
    }

    @Override
    public List<Feed> findAllByPrivacyTypeAndIsArchivedAndAndUserIdAccountTypeOrderByUploadDate(String privacyType, boolean isArchived, String AccountType) {
        return feedRepository.findAllByPrivacyTypeAndIsArchivedAndAndUserIdAccountTypeOrderByUploadDate(privacyType, isArchived, AccountType);
    }
    public Feed save(Feed feed) {
        return feedRepository.save(feed);
    }


    @Override
    public Optional<Feed> findById(Long feedId) {
        return feedRepository.findById(feedId);
    }
}

