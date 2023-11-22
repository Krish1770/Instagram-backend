package com.example.Instagrambackend.Repository.Service;

import com.example.Instagrambackend.Model.FeedView;
//import com.example.Instagrambackend.Model.Feed_View;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedViewRepoService {
    public List<FeedView> displayFeedView();

}
