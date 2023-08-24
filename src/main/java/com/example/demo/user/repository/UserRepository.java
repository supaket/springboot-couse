package com.example.demo.user.repository;

import com.example.demo.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findById(int id);
    List<UserEntity> findAll();

}
