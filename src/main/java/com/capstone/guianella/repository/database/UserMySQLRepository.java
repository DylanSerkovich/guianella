package com.capstone.guianella.repository.database;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.guianella.entity.UserEntity;

public interface UserMySQLRepository extends JpaRepository<UserEntity, Integer> {
    @Query(value = "SELECT u.* FROM user u " +
            "INNER JOIN user_rol ur ON u.id_user = ur.id_user " +
            "INNER JOIN rol r ON ur.rol_id = r.rol_id " +
            "WHERE r.name != ?1 ", nativeQuery = true)
    public List<UserEntity> findAllNotRole(String role);
}
