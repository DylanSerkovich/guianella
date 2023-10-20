package com.capstone.guianella.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.guianella.entity.ProductEntity;

@Repository
public interface ProductionMySQLRepository extends JpaRepository<ProductEntity,Integer>{

    
    
}
