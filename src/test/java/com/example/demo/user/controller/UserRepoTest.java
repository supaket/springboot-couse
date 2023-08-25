package com.example.demo.user.controller;


import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepoTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldBeAbleToFindUserData(){
        //Arrange
        userRepository.deleteAll();
        UserEntity saved = new UserEntity();
        saved.setId(10L);
        saved.setName("user 10");
        userRepository.save(saved);
        //Act
        Optional<UserEntity> user = userRepository.findById(10L);

        //Assert
        //user.get().getId() == 10;
        UserEntity result = user.get();
        assertEquals(result.getId(), 10L);

    }
}
