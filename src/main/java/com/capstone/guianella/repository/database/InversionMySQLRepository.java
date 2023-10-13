package com.capstone.guianella.repository.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.guianella.entity.InversionEntity;

@Repository
public interface InversionMySQLRepository extends JpaRepository<InversionEntity, Integer> {

    @Query(value = "SELECT * FROM inversion WHERE date_complete IS NULL", nativeQuery = true)
    List<InversionEntity> findAllNoTerminate();

}
