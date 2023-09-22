package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<User> createUser(User user) {
         User userByEmail;
      userByEmail =userRepository.findByEmailId(user.getEmailId());

        System.out.println(userByEmail);
         if(userByEmail==null)
         {

             userRepository.save(user);
             System.out.println("sdgdf");
             return ResponseEntity.status(HttpStatus.OK).body(new User(HttpStatus.OK,"User Added Successfully",""));

         }

         return ResponseEntity.status(HttpStatus.OK).body(new User(HttpStatus.NOT_FOUND,"email Already Exist",""));
    }


}
