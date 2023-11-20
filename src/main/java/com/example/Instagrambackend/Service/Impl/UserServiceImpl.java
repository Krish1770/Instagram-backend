package com.example.Instagrambackend.Service.Impl;

import com.example.Instagrambackend.Auth.JWTService;
import com.example.Instagrambackend.DTO.LoginDTO;
import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.Service.UserRepoService;
import com.example.Instagrambackend.Repository.UserRepository;
import com.example.Instagrambackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepoService userRepoService;

    @Autowired
    private JWTService jwtService;


    public ResponseEntity<ResponseDTO> createUser(User user) {
         User userByEmail;
      userByEmail =userRepoService.findByEmailId(user.getEmailId());

        System.out.println(userByEmail);
         if(userByEmail==null)
         {

             user.setIsActive(true);
            User savedUser=userRepoService.save(user);

             System.out.println("sdgdf");
             return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"User Added Successfully",savedUser));

         }

         return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND,"email Already Exist",""));


    }


    public ResponseEntity<ResponseDTO> deleteUser(Long userId) {
        User tempUser=userRepoService.findById(userId).get();

        if(tempUser!=null)
        {
            tempUser.setIsActive(false);
            userRepoService.save(tempUser);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"User Deleted Successfully",userId));


        }
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.BAD_REQUEST,"User not found",userId));


    }
    public User isUserValid(String email)
    {
        return userRepoService.findByEmailId(email);
    }


    public ResponseEntity<ResponseDTO> login(LoginDTO loginDTO,User user)
    {
           return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,jwtService.generateToken(loginDTO.getEmail()),""));


//       return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.NOT_FOUND,"invalid user",""));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepoService.findByEmailId(email);
    }
}
