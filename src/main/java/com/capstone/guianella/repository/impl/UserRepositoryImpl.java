package com.capstone.guianella.repository.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.capstone.guianella.entity.UserEntity;

import com.capstone.guianella.repository.UserRepository;
import com.capstone.guianella.repository.database.UserMySQLRepository;

import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserMySQLRepository userRepository;

    @Override
    public void save(UserEntity entity) {
        userRepository.save(entity);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserEntity> findAllNotRol(String rol) {
        return userRepository.findAllNotRole(rol);
    }

    @Override
    public UserEntity findByEmail(String email, Boolean enable) {
        Optional<UserEntity> usuarioOptional = userRepository.findByEmailAndEnable(email, enable);
        return usuarioOptional.orElse(null);
    }

}
