package com.capstone.guianella.repository.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.guianella.entity.RolEntity;

public interface RolMySQLReporsitory extends JpaRepository<RolEntity, Integer> {

    public RolEntity findByName(String rol);

    @Query(value = "SELECT * FROM rol WHERE name != 'ADMIN'", nativeQuery = true)
    public List<RolEntity> findAllNotAdmin();
}
