package com.example.Instagrambackend.repository.service;

import com.example.Instagrambackend.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface UserRepoService  {
    
  
    User findByEmailId(String emailId);

    Optional<User> findById(Long userId);

    User save(User user);

}
