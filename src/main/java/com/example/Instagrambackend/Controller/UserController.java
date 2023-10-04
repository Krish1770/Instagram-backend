package com.example.Instagrambackend.Controller;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.UserRepository;
import com.example.Instagrambackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("createUser")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody User user)
    {
        System.out.println(user.toString()+"  sggery");
        return userService.createUser(user);
    }

    @DeleteMapping("deleteUser/{userId}")
    public ResponseEntity<ResponseDTO> DeleteUser(@PathVariable Long userId)
    {
        return userService.deleteUser(userId);
    }


}
