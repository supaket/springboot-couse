package com.example.demo.user.controller;

import com.example.demo.user.domain.UserResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserResponse> users() {

        UserResponse user1 = new UserResponse();
        user1.setName("user1");
        UserResponse user2 = new UserResponse();
        user2.setName("user2");

        List<UserResponse> userList = new ArrayList();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }
}
