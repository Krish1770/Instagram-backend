package com.example.Instagrambackend.repository;

import com.example.Instagrambackend.model.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {
    @Query(value = "SELECT * from Relation tr WHERE tr.userKey.sender=:sender AND tr.userKey.receiver=:receiver", nativeQuery = true)
    Relation findBySenderAndReceiver(Long sender, Long receiver);

    Optional<Relation> findByUserKeySenderUserIdAndUserKeyReceiverUserId(Long sender, Long Receiver);

    Optional<List<Relation>> findByUserKeySenderUserIdOrUserKeyReceiverUserIdAndStatus(Long userId1,Long userId2,String Status);

    Optional<List<Relation>> findByUserKeyReceiverUserIdAndFollowing(Long userId,Boolean isFollowing);

    Optional<List<Relation>> findAllByUserKeySenderUserIdAndFollowingOrStatus(Long userId1,Boolean following,String status);
}


