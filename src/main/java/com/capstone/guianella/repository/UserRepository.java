package com.capstone.guianella.repository;

import java.util.List;

import com.capstone.guianella.entity.UserEntity;

public interface UserRepository {
    void save(UserEntity user);

    List<UserEntity> findAllNotRol(String rol);

    List<UserEntity> findAll();

    // Employee findByUsername(String username);
}
