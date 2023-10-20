package com.capstone.guianella.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.guianella.entity.ConfectionEntity;
import com.capstone.guianella.repository.ConfeccionRepository;
import com.capstone.guianella.repository.database.ConfeccionMySQLRepository;

public class ConfeccionRepositoryImpl implements ConfeccionRepository {

    @Autowired
    private ConfeccionMySQLRepository repository;

    @Override
    public void save(ConfectionEntity confectionEntity) {
        
        repository.save(confectionEntity);
    }

}
