package com.example.Instagrambackend.controller;

import com.example.Instagrambackend.api.CategoryApi;
import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.model.Category;
import com.example.Instagrambackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    @Autowired
    private CategoryService categoryService;



    @Override
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }

    @Override
    public ResponseEntity<ResponseDTO> addCategory(Category category) {
        System.out.println(category);
        return categoryService.addCategory(category);
    }


}
