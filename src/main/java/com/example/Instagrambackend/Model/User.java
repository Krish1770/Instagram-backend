package com.example.Instagrambackend.Model;

//import com.example.Instagrambackend.DTO.ResponseDTO;
import jakarta.persistence.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

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

    public User(HttpStatus httpStatus, String userAddedSuccessfully, User user) {
    }

    public User(HttpStatus httpStatus, String emailAlreadyExist, String s) {
    }
    public User() {

    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;

    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", Role='" + Role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", emailId='" + emailId + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
