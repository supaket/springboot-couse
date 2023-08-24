package com.example.demo.user.controller;

import com.example.demo.user.domain.UserResponse;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserResponse> users() {

        UserResponse user1 = new UserResponse();
        user1.setId("1");
        user1.setName("user1");

        UserResponse user2 = new UserResponse();
        user2.setId("2");
        user2.setName("user2");

        List<UserResponse> userList = new ArrayList();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable String id){

        UserResponse user1 = new UserResponse();
        user1.setId("1");
        user1.setName("user1");

        UserResponse user2 = new UserResponse();
        user2.setId("2");
        user2.setName("user2");

        List<UserResponse> userList = new ArrayList();
        userList.add(user1);
        userList.add(user2);

        //create a response user with assign the id
        UserResponse userResponse = new UserResponse();


        //search a user by compare given id with user in list
        userList.forEach(u -> {
            if(u.getId().equals(id)){
                // if found then assign name and id
                 userResponse.setId(id);
                 userResponse.setName(u.getName());
            }
        });

       return userResponse;
    }
}
