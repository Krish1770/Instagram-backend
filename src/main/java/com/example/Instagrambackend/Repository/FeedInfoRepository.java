package com.example.Instagrambackend.Repository;


import com.example.Instagrambackend.Model.CommentInfo;
import com.example.Instagrambackend.Model.FeedInfo;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedInfoRepository extends MongoRepository<FeedInfo,String> {

    Optional<FeedInfo> findByFeedId(Long FeedId);

    Optional<CommentInfo> findByFeedIdAndCommentInfoId(Long feedId, String commentId);
}
