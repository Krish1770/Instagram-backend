package com.example.Instagrambackend.Repository.Service.Impl;

import com.example.Instagrambackend.Model.FeedView;
//import com.example.Instagrambackend.Model.Feed_View;
import com.example.Instagrambackend.Repository.FeedViewRepository;
import com.example.Instagrambackend.Repository.Service.FeedRepoService;
import com.example.Instagrambackend.Repository.Service.FeedViewRepoService;
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
