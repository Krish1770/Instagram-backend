package com.example.Instagrambackend.Controller;
import com.example.Instagrambackend.Api.UserControllerApi;
import com.example.Instagrambackend.DTO.LoginDTO;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController implements UserControllerApi {


    @Autowired
    private UserService userservice;


    public ResponseEntity<ResponseDTO> createUser( User user)
    {
        System.out.println(user.toString()+"  sggery");
        return userservice.createUser(user);
    }


    public ResponseEntity<ResponseDTO> DeleteUser(@PathVariable Long userId)
    {
        return userservice.deleteUser(userId);
    }


    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO)
    {
        User validUser=userservice.isUserValid(loginDTO.getEmail());

        if(validUser!=null)
            return userservice.login(loginDTO,validUser);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND,"user not found",""));
    }
}
