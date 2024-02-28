package com.example.Instagrambackend.repository;

import com.example.Instagrambackend.model.FeedView;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.
import org.springframework.stereotype.Repository;

@Repository
public interface FeedViewRepository extends JpaRepository<FeedView,Long> {

//@Query(value = "select * from feed_view")
//    List<Feed_View> display();
}
