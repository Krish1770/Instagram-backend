package com.example.Instagrambackend.Repository.Service;


import com.example.Instagrambackend.Model.CommentInfo;
import com.example.Instagrambackend.Model.FeedInfo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface FeedInfoRepoService {
    Optional<FeedInfo> findByFeedId(Long feedId);

    Optional<CommentInfo> findByFeedIdAndCommentInfoId(Long feedId, String commentId);
}
