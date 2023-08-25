package com.example.demo.user.controller;


import com.example.demo.user.domain.UserDomain;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
public class UserServiceTest {

    @MockBean
    UserRepository userRepo;

    @Test
    public void shouldUserServiceReturnUserDomain(){

        UserEntity userEntity = new UserEntity();
        userEntity.setId(10L);
        userEntity.setName("user 10");

        when(userRepo.findById(10L)).thenReturn (Optional.of(userEntity));

        UserService userservice = new UserService(userRepo);
        UserDomain userDomain = userservice.findById(10);

        assertEquals(userDomain.getName(), "user 10");
    }
}
