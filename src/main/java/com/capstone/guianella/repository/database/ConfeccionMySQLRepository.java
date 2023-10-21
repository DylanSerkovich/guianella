package com.capstone.guianella.repository.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.guianella.entity.ConfectionEntity;

@Repository
public interface ConfeccionMySQLRepository extends JpaRepository<ConfectionEntity, Integer> {
    // @Query(value = "SELECT * FROM confetion WHERE id_inversion= :idInversion",
    // nativeQuery = true)
    // Optional<ConfectionEntity> findbyInversion(@Param(value = "idInversion") int
    // idInversion);

}
