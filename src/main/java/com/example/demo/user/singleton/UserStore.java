package com.example.demo.user.singleton;

import com.example.demo.user.domain.UserResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserStore {
    @Bean
    @Scope("singleton")
    public List<UserResponse> userList() {

        List<UserResponse> userList = new ArrayList<UserResponse>();
        UserResponse user1 = new UserResponse();
        user1.setId(1);
        user1.setName("user1");

        UserResponse user2 = new UserResponse();
        user2.setId(2);
        user2.setName("user2");

        userList.add(user1);
        userList.add(user2);

        return userList;
    }
}
