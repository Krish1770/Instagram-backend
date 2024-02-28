package com.example.Instagrambackend.repository.service.Impl;

import com.example.Instagrambackend.model.FeedView;
//import com.example.Instagrambackend.Model.Feed_View;
import com.example.Instagrambackend.repository.FeedViewRepository;
import com.example.Instagrambackend.repository.service.FeedViewRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FeedViewRepoServiceImpl implements FeedViewRepoService {


    @Autowired
    private FeedViewRepository feedViewRepository;

    @Override
    public List<FeedView> displayFeedView() {
        return null;
    }
}
