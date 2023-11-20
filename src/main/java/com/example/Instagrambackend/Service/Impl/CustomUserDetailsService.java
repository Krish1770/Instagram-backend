//package com.example.Instagrambackend.Service.Impl;
//
//import com.example.Instagrambackend.Model.User;
//import com.example.Instagrambackend.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Collection;
//import java.util.List;
//
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user=userRepository.findByEmailId(email);
//        if(user==null)
//        {
//            throw  new UsernameNotFoundException("email not found");
//        }
//        return new User(
//                user.getEmailId(),
//                user.getPassword(),
//                user.isEnabled(),
//                true,
//                true,
//                true,
//                user.getAuthorities(List.of(user.getRole()))
//        );
//
//    }
//
//
//}