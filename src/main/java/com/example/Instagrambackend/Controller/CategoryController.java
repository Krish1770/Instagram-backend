package com.example.Instagrambackend.Controller;

import com.example.Instagrambackend.Api.CategoryApi;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.Category;
import com.example.Instagrambackend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
