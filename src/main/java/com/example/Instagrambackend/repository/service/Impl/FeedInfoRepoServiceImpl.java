package com.example.Instagrambackend.repository.service.Impl;


import com.example.Instagrambackend.model.CommentInfo;
import com.example.Instagrambackend.model.FeedInfo;
import com.example.Instagrambackend.repository.FeedInfoRepository;
import com.example.Instagrambackend.repository.service.FeedInfoRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedInfoRepoServiceImpl implements FeedInfoRepoService {

    @Autowired
    private FeedInfoRepository feedInfoRepository;
    @Override
    public Optional<FeedInfo> findByFeedId(Long feedId) {
        return feedInfoRepository.findByFeedId(feedId);
    }

    @Override
    public Optional<CommentInfo> findByFeedIdAndCommentInfoId(Long feedId, String commentId) {
        return feedInfoRepository.findByFeedIdAndCommentInfoId(feedId,commentId);
    }
}
