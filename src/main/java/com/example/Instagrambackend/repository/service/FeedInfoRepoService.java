package com.example.Instagrambackend.repository.service;


import com.example.Instagrambackend.model.CommentInfo;
import com.example.Instagrambackend.model.FeedInfo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FeedInfoRepoService {
    Optional<FeedInfo> findByFeedId(Long feedId);

    Optional<CommentInfo> findByFeedIdAndCommentInfoId(Long feedId, String commentId);
}
