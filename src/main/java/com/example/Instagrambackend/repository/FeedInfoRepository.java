package com.example.Instagrambackend.repository;


import com.example.Instagrambackend.model.CommentInfo;
import com.example.Instagrambackend.model.FeedInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedInfoRepository extends MongoRepository<FeedInfo,String> {

    Optional<FeedInfo> findByFeedId(Long FeedId);

    Optional<CommentInfo> findByFeedIdAndCommentInfoId(Long feedId, String commentId);
}
