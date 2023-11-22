package com.example.Instagrambackend.Repository;

import com.example.Instagrambackend.Model.FeedView;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedViewRepository extends JpaRepository<FeedView,Long> {

//@Query(value = "select * from feed_view")
//    List<Feed_View> display();
}
