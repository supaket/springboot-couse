package com.example.demo.user.controller;

import com.example.demo.user.domain.UserDomain;
import com.example.demo.user.domain.UserResponse;
import com.example.demo.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponse> users() {
        List<UserResponse> userResponses = new ArrayList<>();
        List<UserDomain> users =  this.userService.findAll();
        users.forEach(userDomain -> {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setName(userDomain.getName());
                    userResponse.setId(userDomain.getId());
                    userResponses.add(userResponse);
                }
                );
        return userResponses;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable int id){
        UserResponse userResponse = new UserResponse();

        UserDomain userDomain = userService.findById(id);
        if(userDomain != null) {
            userResponse.setId(userDomain.getId());
            userResponse.setName(userDomain.getName());
        }
        return userResponse;
    }

//    @PostMapping("/users")
//    public UserResponse createUser(@RequestBody UserRequest userRequest){
//        UserResponse newUser= new UserResponse();
//        newUser.setName(userRequest.getName());
//        int currentId = userStore.userList().size();
//        newUser.setId(currentId+1);
//        userStore.userList().add(newUser);
//
//        return newUser;
//    }
//
//    @PutMapping("/users/{id}")
//    public UserResponse updateUser(@RequestBody UserRequest userRequest,
//                            @PathVariable String id){
//
//        UserResponse userResponse = new UserResponse();
//        //search a user by compare given id with user in list
//        userStore.userList().forEach(user -> {
//            if(user.getId() == Integer.parseInt(id)){
//
//                // if found then assign name and id
//                userResponse.setId(Integer.parseInt(id));
//                userResponse.setName(userRequest.getName());
//
//                // Update found user with new name from request
//                user.setName(userRequest.getName());
//            }
//        });
//
//        return userResponse;
//    }
//
//
//    @DeleteMapping("/users/{id}")
//    public String deleteUser(@PathVariable int id){
//        UserResponse user = new UserResponse();
//        user.setId(id);
//
//        userStore.userList().remove(user);
//        return "user id " + id + " deleted";
//    }
}
