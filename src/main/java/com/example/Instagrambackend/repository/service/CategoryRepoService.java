package com.example.Instagrambackend.repository.service;

import com.example.Instagrambackend.model.Category;

import java.util.List;

public interface CategoryRepoService {
    Category save(Category category1);

    List<Category> findAll();
}
