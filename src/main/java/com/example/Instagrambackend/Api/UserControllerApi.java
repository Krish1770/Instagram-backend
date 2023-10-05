package com.example.Instagrambackend.Api;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user/")
public interface UserControllerApi {
    @DeleteMapping("deleteUser/{userId}")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody User user);

    @PostMapping("createUser")
    public ResponseEntity<ResponseDTO> DeleteUser(@PathVariable Long userId);

}
