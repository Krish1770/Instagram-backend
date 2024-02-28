package com.example.Instagrambackend.service.impl;

import com.example.Instagrambackend.advice.UserNotFoundException;
import com.example.Instagrambackend.auth.JWTService;
import com.example.Instagrambackend.dto.LoginDTO;
import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.model.User;
import com.example.Instagrambackend.repository.service.UserRepoService;
import com.example.Instagrambackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepoService userRepoService;

    @Autowired
    private JWTService jwtService;


    @Valid
    public ResponseEntity<ResponseDTO> createUser(User user) {
         User userByEmail=null;
      userByEmail =userRepoService.findByEmailId(user.getEmailId());
        System.out.println("service");
        System.out.println(userByEmail);
         if(userByEmail==null)
         {

             user.setIsActive(true);
            User savedUser=userRepoService.save(user);

             System.out.println("sdgdf");
             return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"User Added Successfully",savedUser));

         }

         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(HttpStatus.NOT_FOUND,"email Already Exist",""));
    }
    public ResponseEntity<ResponseDTO> deleteUser(Long userId) {
        Optional<User> tempUser=userRepoService.findById(userId);

        if(tempUser.isPresent())
        {
            tempUser.get().setIsActive(false);
            userRepoService.save(tempUser.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"User Deleted Successfully",userId));
        }

        System.out.println("service");
        throw new UserNotFoundException();
    }
    public User isUserValid(String email)
    {
        return userRepoService.findByEmailId(email);
    }

    public Optional<User> isUserValid(Long userId)
    {
        return userRepoService.findById(userId);
    }
    public ResponseEntity<ResponseDTO> login(LoginDTO loginDTO,User user)
    {
           return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,jwtService.generateToken(loginDTO.getEmail()),""));


    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepoService.findByEmailId(email);
    }
}