package com.capstone.guianella.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.guianella.entity.ProductEntity;
import com.capstone.guianella.repository.ProductionRepository;
import com.capstone.guianella.repository.database.ProductionMySQLRepository;

public class ProductionRepositoryImpl implements ProductionRepository {

    @Autowired
    private ProductionMySQLRepository repository;

    @Override
    public void save(ProductEntity productEntity) {
        repository.save(productEntity);
    }

}
