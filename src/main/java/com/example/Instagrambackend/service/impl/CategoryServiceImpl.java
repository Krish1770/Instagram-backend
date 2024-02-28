package com.example.Instagrambackend.service.impl;

import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.model.Category;
import com.example.Instagrambackend.repository.service.CategoryRepoService;
import com.example.Instagrambackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepoService categoryRepoService;

    @Override
    public ResponseEntity<ResponseDTO> addCategory(Category category) {



        Category category1=categoryRepoService.save(category);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"category added",category1));

    }

    @Override
    public ArrayList<Category> getCategory() {
        List<Category> categoryList=categoryRepoService.findAll();

        ArrayList<Category> categoryArrayList=new ArrayList<>(categoryList);
      return categoryArrayList;
    }
}
