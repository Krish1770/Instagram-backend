package com.example.Instagrambackend.Repository.Service;

import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface UserRepoService  {
    
  
    User findByEmailId(String emailId);

    Optional<User> findById(Long userId);

    User save(User user);

}
