package com.example.Instagrambackend.Api;

import com.example.Instagrambackend.DTO.LoginDTO;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user/")
public interface UserControllerApi {


    @PostMapping("createUser")
    ResponseEntity<ResponseDTO> createUser(@RequestBody User user);




    @DeleteMapping("deleteUser/{userId}")
     ResponseEntity<ResponseDTO> DeleteUser(@PathVariable Long userId);

    @PostMapping("login")
//    @PreAuthorize("hasAuthority('ADMIN,'USER')")
     ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO);
}
