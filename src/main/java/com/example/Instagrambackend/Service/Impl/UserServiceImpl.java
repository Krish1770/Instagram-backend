package com.example.Instagrambackend.Service.Impl;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.Service.UserRepoService;
import com.example.Instagrambackend.Repository.UserRepository;
import com.example.Instagrambackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepoService userRepoService;


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
    public boolean isUserValid(Long userId)
    {
        return userRepoService.findById(userId).isPresent();
    }


}
