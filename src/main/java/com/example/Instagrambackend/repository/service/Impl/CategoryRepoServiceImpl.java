package com.example.Instagrambackend.repository.service.Impl;

import com.example.Instagrambackend.model.Category;
import com.example.Instagrambackend.repository.CategoryRepository;
import com.example.Instagrambackend.repository.service.CategoryRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryRepoServiceImpl implements CategoryRepoService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category save(Category category1) {
    return  categoryRepository.save(category1);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
