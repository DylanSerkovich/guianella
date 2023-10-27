package com.capstone.guianella.repository.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.guianella.entity.ProductEntity;

@Repository
public interface ProductionMySQLRepository extends JpaRepository<ProductEntity,Integer>{

    @Query(value = "SELECT * FROM product WHERE id_inversion= :idInversion", nativeQuery = true)
    List<ProductEntity> findAllByIdInversion(@Param(value = "idInversion") int idInversion);
}
