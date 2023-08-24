package com.example.demo.user.service;


import com.example.demo.user.domain.UserDomain;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    final
    UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserDomain findById(int id) {
        Optional<UserEntity> userEntity = userRepo.findById(id);
        if(userEntity.isPresent()) {
            return new UserDomain(
                    userEntity.get().getId().intValue(),
                    userEntity.get().getName());
        }
        return null;
    }

    public List<UserDomain> findAll(){
        List<UserEntity> userEntities = userRepo.findAll();
        List<UserDomain> users = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            users.add(new UserDomain(userEntity.getId().intValue(),
            userEntity.getName()));
        });
        return users;
    }
}