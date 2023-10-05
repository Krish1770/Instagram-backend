package com.example.Instagrambackend.Repository.Service.Impl;

import com.example.Instagrambackend.Model.Feed;
import com.example.Instagrambackend.Model.Relation;
import com.example.Instagrambackend.Repository.RelationRepository;
import com.example.Instagrambackend.Repository.Service.FeedRepoService;
import com.example.Instagrambackend.Repository.Service.RelationRepoService;

import java.util.List;
import java.util.Optional;

public class RelationRepoServiceImpl implements RelationRepoService {


    private RelationRepository relationRepository;
    @Override
    public Optional<Relation> findByUserKeySenderUserIdAndUserKeyReceiverUserId(Long sender, Long Receiver) {
        return relationRepository.findByUserKeySenderUserIdAndUserKeyReceiverUserId(sender,Receiver);
    }

    @Override
    public Optional<List<Relation>> findByUserKeySenderUserIdOrUserKeyReceiverUserIdAndStatus(Long userId1, Long userId2, String Status) {
        return ;
    }

    @Override
    public Optional<List<Relation>> findByUserKeyReceiverUserIdAndFollowing(Long userId, Boolean isFollowing) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Relation>> findAllByUserKeySenderUserIdAndFollowingOrStatus(Long userId1, Boolean following, String status) {
        return Optional.empty();
    }
}
