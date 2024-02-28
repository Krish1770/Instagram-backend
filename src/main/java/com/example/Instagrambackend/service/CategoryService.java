package com.example.Instagrambackend.service;

import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<ResponseDTO> addCategory(Category category);

    List<Category> getCategory();
}
