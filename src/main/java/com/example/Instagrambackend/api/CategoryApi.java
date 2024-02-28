package com.example.Instagrambackend.api;

import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.model.Category;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/category")
public interface CategoryApi {


//    @CachePut(value = "displayCategory",key = "display")
//    @GetMapping("/display")


    @CachePut(value = "categoryList")
    @GetMapping("/get")
    List<Category> getCategory();

        @PostMapping("/Category")
    ResponseEntity<ResponseDTO> addCategory(@RequestBody  Category category);
}
