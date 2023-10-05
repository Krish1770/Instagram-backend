package com.example.Instagrambackend.Service;

import com.example.Instagrambackend.DTO.ResponseDTO;
import com.example.Instagrambackend.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public ResponseEntity<ResponseDTO> createUser(User user);

    public ResponseEntity<ResponseDTO> deleteUser(Long userId);

    public boolean isUserValid(Long userId);
}
