package com.capstone.guianella.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.capstone.guianella.entity.UserEntity;

public interface UserRepository {
    void save(UserEntity user);

    UserEntity findByEmail(String email, Boolean enable);

    UserEntity finByResetPasswordToken(String token);

    List<UserEntity> findAllNotRol(String rol);

    List<UserEntity> findAll();

    UserEntity findByEmailOrUsername(String email, String username);

    UserEntity existsByEmailOrUsernameAndDifferentId(String email, String username, int id);

    Boolean updateEnabledUser(boolean enable, int id);

    UserEntity findByid(int idUser);
    // Employee findByUsername(String username);
}
