package com.example.Instagrambackend.Api;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.Category;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
