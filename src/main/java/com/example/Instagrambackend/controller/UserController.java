package com.example.Instagrambackend.controller;
import com.example.Instagrambackend.api.UserControllerApi;
import com.example.Instagrambackend.dto.LoginDTO;
import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.model.User;
import com.example.Instagrambackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController implements UserControllerApi {


    @Autowired
    private UserService userservice;


    @Valid
    public ResponseEntity<ResponseDTO> createUser( User user)
    {
        System.out.println(user.toString()+"  sggery");
        return userservice.createUser(user);
    }


    public ResponseEntity<ResponseDTO> DeleteUser(@PathVariable Long userId)
    {
        System.out.println("deletion");
        return userservice.deleteUser(userId);
    }


    public ResponseEntity<ResponseDTO> login(LoginDTO loginDTO)
    {
        User validUser=userservice.isUserValid(loginDTO.getEmail());
        System.out.println(validUser.getPassword());
        if(validUser.getPassword().equals(loginDTO.getPassword()))
            return userservice.login(loginDTO,validUser);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND,"user not found",""));
    }
}
