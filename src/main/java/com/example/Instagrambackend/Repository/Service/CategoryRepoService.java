package com.example.Instagrambackend.Repository.Service;

import com.example.Instagrambackend.Model.Category;

import java.util.List;

public interface CategoryRepoService {
    Category save(Category category1);

    List<Category> findAll();
}
