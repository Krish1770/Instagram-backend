package com.example.Instagrambackend.repository.service;

import com.example.Instagrambackend.model.Relation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface RelationRepoService
{
    Optional<Relation> findByUserKeySenderUserIdAndUserKeyReceiverUserId(Long sender, Long Receiver);

    Optional<List<Relation>> findByUserKeySenderUserIdOrUserKeyReceiverUserIdAndStatus(Long userId1, Long userId2, String Status);

    Optional<List<Relation>> findByUserKeyReceiverUserIdAndFollowing(Long userId,Boolean isFollowing);

    Optional<List<Relation>> findAllByUserKeySenderUserIdAndFollowingOrStatus(Long userId1,Boolean following,String status);

    Relation save(Relation relation);
}
