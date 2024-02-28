package com.example.Instagrambackend.repository;

import com.example.Instagrambackend.model.User;
//import com.example.Instagrambackend.Model.UserKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByEmailId(String emailId);

}
