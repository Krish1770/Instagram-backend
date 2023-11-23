package com.example.Instagrambackend.Model;

//import com.example.Instagrambackend.DTO.ResponseDTO;

import com.example.Instagrambackend.Constants.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_info")
public class User implements UserDetails, CredentialsContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String accountType;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    @Min(value = 1, message = "error")
    @Max(value = 10)
    @Column(nullable = true)
    private Integer age;
//    @Column(nullable = false)



     @NotNull
    private String emailId;
    @Column(length = 10)
    @Pattern(regexp = "^[0-9]]",message = "length of mobileNumber must be 10")
    private String mobileNumber;

    private Boolean isActive;


    private String password;


    @Override
    public boolean isEnabled() {
        return false;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public void eraseCredentials() {
    }


    @Override
    public String getUsername() {
        return emailId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
