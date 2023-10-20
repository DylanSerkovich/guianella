package com.capstone.guianella.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.guianella.entity.ConfectionEntity;

@Repository
public interface ConfeccionMySQLRepository extends JpaRepository<ConfectionEntity, Integer> {

}
