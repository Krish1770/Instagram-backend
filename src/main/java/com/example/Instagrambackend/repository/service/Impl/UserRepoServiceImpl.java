package com.example.Instagrambackend.repository.service.Impl;

import com.example.Instagrambackend.model.User;
import com.example.Instagrambackend.repository.service.UserRepoService;
import com.example.Instagrambackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepoServiceImpl implements UserRepoService {

  @Autowired
  private UserRepository userRepository;
    @Override
    public User findByEmailId(String emailId) {
        System.out.println(emailId);
        return userRepository.findByEmailId(emailId);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
