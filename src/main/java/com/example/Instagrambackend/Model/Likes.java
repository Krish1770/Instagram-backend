package com.example.Instagrambackend.Model;


import com.example.Instagrambackend.Constants.LikeType;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.usertype.UserVersionType;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Likes {

    private List<User> likedUsers;


}
