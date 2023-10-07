package com.example.Instagrambackend.DTO;

import com.example.Instagrambackend.Model.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedDTO  {

//    public MultipartFile getFile() {
//        return file;
//    }
//
//    public void setFile(MultipartFile file) {
//        this.file = file;
//    }
//
//    private MultipartFile file;
    private Long user;
    private String privacyType;
    private String type;

    public Long getUser() {
        return user;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getPrivacyType() {
        return privacyType;
    }

    public void setPrivacyType(String privacyType) {
        this.privacyType = privacyType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
