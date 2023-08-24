package com.example.demo.user.controller;

import com.example.demo.user.domain.UserRequest;
import com.example.demo.user.domain.UserResponse;
import com.example.demo.user.singleton.UserStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    final
    UserStore userStore;

    public UserController(UserStore userStore) {
        this.userStore = userStore;
    }

    @GetMapping("/users")
    public List<UserResponse> users() {
        return userStore.userList();
    }

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable String id){
        UserResponse userResponse = new UserResponse();
        //search a user by compare given id with user in list
        userStore.userList().forEach(u -> {
            if(u.getId() == Integer.parseInt(id)){
                // if found then assign name and id
                 userResponse.setId(Integer.parseInt(id));
                 userResponse.setName(u.getName());
            }
        });

       return userResponse;
    }

    @PostMapping("/users")
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        UserResponse newUser= new UserResponse();
        newUser.setName(userRequest.getName());
        int currentId = userStore.userList().size();
        newUser.setId(currentId+1);
        userStore.userList().add(newUser);

        return newUser;
    }

    @PutMapping("/users/{id}")
    public UserResponse updateUser(@RequestBody UserRequest userRequest,
                            @PathVariable String id){

        UserResponse userResponse = new UserResponse();
        //search a user by compare given id with user in list
        userStore.userList().forEach(user -> {
            if(user.getId() == Integer.parseInt(id)){

                // if found then assign name and id
                userResponse.setId(Integer.parseInt(id));
                userResponse.setName(userRequest.getName());

                // Update found user with new name from request
                user.setName(userRequest.getName());
            }
        });

        return userResponse;
    }


    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        UserResponse user = new UserResponse();
        user.setId(id);

        userStore.userList().remove(user);
        return "user id " + id + " deleted";
    }
}
