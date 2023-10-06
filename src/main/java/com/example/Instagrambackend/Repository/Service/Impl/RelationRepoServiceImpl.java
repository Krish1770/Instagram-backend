package com.example.Instagrambackend.Repository.Service.Impl;

import com.example.Instagrambackend.Model.Feed;
import com.example.Instagrambackend.Model.Relation;
import com.example.Instagrambackend.Repository.RelationRepository;
import com.example.Instagrambackend.Repository.Service.FeedRepoService;
import com.example.Instagrambackend.Repository.Service.RelationRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationRepoServiceImpl implements RelationRepoService {


    @Autowired
    private RelationRepository relationRepository;
    @Override
    public Optional<Relation> findByUserKeySenderUserIdAndUserKeyReceiverUserId(Long sender, Long Receiver) {
        return relationRepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(sender,Receiver);
    }

    @Override
    public Optional<List<Relation>> findByUserKeySenderUserIdOrUserKeyReceiverUserIdAndStatus(Long userId1, Long userId2, String status) {
        return relationRepository.findByUserKeySenderUserIdOrUserKeyReceiverUserIdAndStatus(userId1,userId2,status);
    }

    @Override
    public Optional<List<Relation>> findByUserKeyReceiverUserIdAndFollowing(Long userId, Boolean isFollowing) {
        return relationRepository.findByUserKeyReceiverUserIdAndFollowing(userId,isFollowing);
    }

    @Override
    public Optional<List<Relation>> findAllByUserKeySenderUserIdAndFollowingOrStatus(Long userId1, Boolean following, String status) {
        return relationRepository.findAllByUserKeySenderUserIdAndFollowingOrStatus(userId1,following,status);
    }

    @Override
    public Relation save(Relation relation) {
        return relationRepository.save(relation);
    }
}
