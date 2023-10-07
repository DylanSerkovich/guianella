package com.capstone.guianella.repository.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capstone.guianella.entity.UserEntity;

public interface UserMySQLRepository extends JpaRepository<UserEntity, Integer> {

        Optional<UserEntity> findByUsername(String username);

        Optional<UserEntity> findByEmailAndEnable(String email, boolean enable);

        @Query(value = "SELECT * FROM user WHERE LOWER(email) = LOWER(?1) OR username =?2 LIMIT 1", nativeQuery = true)
        Optional<UserEntity> findByEmailOrUsername(String email, String username);

        @Query(value = "SELECT * FROM user WHERE reset_password_token = ?1", nativeQuery = true)
        public UserEntity finByResetPasswordToken(String token);

        @Query(value = "SELECT u.* FROM user u " +
                        "INNER JOIN user_rol ur ON u.id_user = ur.id_user " +
                        "INNER JOIN rol r ON ur.rol_id = r.rol_id " +
                        "WHERE r.name != ?1 ", nativeQuery = true)
        public List<UserEntity> findAllNotRole(String role);

        @Query(value = "SELECT * FROM user WHERE (LOWER(email) = LOWER(?1) OR username =?2) AND id_user != ?3 LIMIT 1", nativeQuery = true)
        public Optional<UserEntity> existsByEmailOrUsernameAndDifferentId(String email, String username, int id);

        @Modifying
        @Query(value = "UPDATE user " +
                        "SET user.enable = :enabled " +
                        "WHERE user.id_user = :id " +
                        "AND NOT EXISTS (" +
                        "SELECT 1 FROM user_rol AS ur " +
                        "JOIN rol AS r ON ur.rol_id = r.rol_id " +
                        "WHERE ur.id_user = :id " +
                        "AND r.name = 'ADMIN' )", nativeQuery = true)
        int updateEnabledUser(@Param(value = "enabled") boolean enable, @Param(value = "id") int id);

}
