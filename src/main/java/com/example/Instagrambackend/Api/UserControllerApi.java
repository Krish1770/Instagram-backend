package com.example.Instagrambackend.Api;

import com.example.Instagrambackend.DTO.LoginDTO;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/user/")
public interface UserControllerApi {


    @PostMapping("createUser")
    ResponseEntity<ResponseDTO> createUser(@Valid @RequestBody User user);




    @CacheEvict(value = "users",key = "#userId")
    @DeleteMapping("deleteUser/{userId}")
     ResponseEntity<ResponseDTO> DeleteUser(@PathVariable Long userId);



    @PostMapping("login")
//    @PreAuthorize("hasAuthority('ADMIN,'USER')")
     ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO);
}
