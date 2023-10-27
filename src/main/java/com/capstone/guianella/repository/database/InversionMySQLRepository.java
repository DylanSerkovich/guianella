package com.capstone.guianella.repository.database;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.guianella.entity.InversionEntity;

@Repository
public interface InversionMySQLRepository extends JpaRepository<InversionEntity, Integer> {

        @Query(value = "SELECT * FROM inversion WHERE date_complete IS NULL", nativeQuery = true)
        List<InversionEntity> findAllNoTerminate();

        @Query(value = "SELECT * FROM inversion WHERE date_complete IS NOT NULL", nativeQuery = true)
        List<InversionEntity> findAllTerminate();

        @Modifying
        @Transactional
        @Query(value = "UPDATE inversion " +
                        "SET inversion.id_confection = :idConfeccion, inversion.date_complete = :dateTerminate " +
                        "WHERE id_inversion= :idInversion", nativeQuery = true)
        int updateConfeccionDateTerminate(@Param(value = "idInversion") int idInversion,
                        @Param(value = "idConfeccion") int idConfeccion,
                        @Param(value = "dateTerminate") Date dateTerminate);

        Optional<InversionEntity> findByIdInversion(int idInversion);

}
