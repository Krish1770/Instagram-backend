package com.example.Instagrambackend.api;

import com.example.Instagrambackend.dto.LoginDTO;
import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.model.User;
import jakarta.validation.Valid;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RequestMapping("/user/")
public interface UserControllerApi {


    @PostMapping("createUser")
    ResponseEntity<ResponseDTO> createUser(@Valid @RequestBody User user);




    @CacheEvict(value = "users",key = "#userId")
    @DeleteMapping("deleteUser/{userId}")
     ResponseEntity<ResponseDTO> DeleteUser(@PathVariable Long userId);



    @PostMapping("/login")
//    @PreAuthorize("hasAuthority('ADMIN,'USER')")
     ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO);
}
