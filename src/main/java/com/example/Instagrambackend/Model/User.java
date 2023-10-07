package com.example.Instagrambackend.Model;

//import com.example.Instagrambackend.DTO.ResponseDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_info")
public class User  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;

   private String accountType;

    private String Role;
    private String firstName;

     private String lastName;

     private Date dateOfBirth;

     private String emailId;

     private String mobileNumber;
    private Boolean isActive;




}
