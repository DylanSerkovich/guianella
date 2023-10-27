package com.capstone.guianella.repository.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.guianella.entity.TelaEntity;

@Repository
public interface TelaMySQLRepository extends JpaRepository<TelaEntity, Integer> {
    @Query(value = "SELECT * FROM tela WHERE id_inversion= :idInversion", nativeQuery = true)
    List<TelaEntity> findByInversion(@Param(value = "idInversion") int idInversion);

    
}
