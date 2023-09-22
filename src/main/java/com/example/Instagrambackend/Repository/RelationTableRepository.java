package com.example.Instagrambackend.Repository;

import com.example.Instagrambackend.Model.Relation;
import com.example.Instagrambackend.Model.UserKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelationTableRepository extends JpaRepository<Relation, Long> {
    @Query("SELECT a from Relation a WHERE a.userKey.sender=:sender AND a.userKey.receiver=:receiver")
    Relation findBySenderAndReceiver(Long sender, Long receiver);
}
