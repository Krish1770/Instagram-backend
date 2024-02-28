package com.example.Instagrambackend.mongoQuery;

import com.example.Instagrambackend.model.FeedInfo;
import com.example.Instagrambackend.model.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class MongoQueries{

    private final MongoTemplate mongoTemplate;

    @Autowired
    private MongoQueries(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate=mongoTemplate;
    }

    public  UpdateResult updateCommentLikes(Long feedId, String commentId, User newUser)
    {


       UpdateResult updateRequest;
        updateRequest = mongoTemplate.updateFirst(
                 query(where("feedId").is(feedId)
                         .and("commentInfo._id").is(commentId)),
                 new Update().push("commentInfo.$.likes.likedUsers", newUser),
                 FeedInfo.class
         );
        return updateRequest;
    }
}