package com.example.Instagrambackend.Repository;

import com.example.Instagrambackend.Model.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface RelationTableRepository extends JpaRepository<Relation, Long> {
    @Query(value = "SELECT * from Relation tr WHERE tr.userKey.sender=:sender AND tr.userKey.receiver=:receiver", nativeQuery = true)
    Relation findBySenderAndReceiver(Long sender, Long receiver);

    Optional<Relation> findByUserKeySenderUserIdAndUserKeyReceiverUserId(Long sender, Long Receiver);

}
