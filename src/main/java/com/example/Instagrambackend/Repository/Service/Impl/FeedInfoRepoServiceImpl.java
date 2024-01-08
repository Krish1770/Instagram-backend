package com.example.Instagrambackend.Repository.Service.Impl;


import com.example.Instagrambackend.Model.CommentInfo;
import com.example.Instagrambackend.Model.FeedInfo;
import com.example.Instagrambackend.Repository.FeedInfoRepository;
import com.example.Instagrambackend.Repository.FeedRepository;
import com.example.Instagrambackend.Repository.Service.FeedInfoRepoService;
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
