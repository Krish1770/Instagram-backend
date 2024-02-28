package com.example.Instagrambackend.service;

import com.example.Instagrambackend.dto.LoginDTO;
import com.example.Instagrambackend.dto.ResponseDTO;
import com.example.Instagrambackend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public ResponseEntity<ResponseDTO> createUser(User user);

    public ResponseEntity<ResponseDTO> deleteUser(Long userId);

    public User isUserValid(String Email);

    public ResponseEntity<ResponseDTO> login(LoginDTO loginDTO,User user);
}
