package com.example.Instagrambackend.repository.service;

import com.example.Instagrambackend.model.FeedView;
//import com.example.Instagrambackend.Model.Feed_View;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedViewRepoService {
    public List<FeedView> displayFeedView();

}
