package com.example.Instagrambackend.Controller;

import com.example.Instagrambackend.DTO.SenderIdReceiverDTO;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.UserRepository;
import com.example.Instagrambackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("createUser")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        System.out.println(user);
        return userService.createUser(user);
    }


}
