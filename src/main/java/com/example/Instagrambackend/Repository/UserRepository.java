package com.example.Instagrambackend.Repository;

import com.example.Instagrambackend.Model.User;
import com.example.Instagrambackend.Model.UserKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByEmailId(String emailId);

//    Optional<User> findByMobileNumber(String mobileNumber);
}
