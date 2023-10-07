package com.example.Instagrambackend.Repository.Service.Impl;

import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Repository.Service.UserRepoService;
import com.example.Instagrambackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepoServiceImpl implements UserRepoService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByEmailId(String emailId) {
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
