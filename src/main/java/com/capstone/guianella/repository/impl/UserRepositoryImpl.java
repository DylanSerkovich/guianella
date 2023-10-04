package com.capstone.guianella.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public UserEntity finByResetPasswordToken(String token) {
        return userRepository.finByResetPasswordToken(token);
    }

    @Override
    public UserEntity findByEmailOrUsername(String email, String username) {
        Optional<UserEntity> usOptional = userRepository.findByEmailOrUsername(email, username);

        return usOptional.orElse(null);
    }

    @Override
    @Transactional
    public Boolean updateEnabledUser(boolean enable, int id) {
        return (userRepository.updateEnabledUser(enable, id) > 0);
    }

}
