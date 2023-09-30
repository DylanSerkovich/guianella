package com.capstone.guianella.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.guianella.entity.RolEntity;

public interface RolMySQLReporsitory extends JpaRepository<RolEntity, Integer> {

    public RolEntity findByName(String rol);
}
