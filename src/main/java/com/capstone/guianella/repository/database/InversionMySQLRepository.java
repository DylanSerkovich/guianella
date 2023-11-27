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
import com.capstone.guianella.projections.CountInvestmenProduction;
import com.capstone.guianella.projections.InversionDateProjection;
import com.capstone.guianella.projections.InversionProjection;
import com.capstone.guianella.projections.InversionTerminateProjection;

@Repository
public interface InversionMySQLRepository extends JpaRepository<InversionEntity, Integer> {

        @Query(value = "SELECT * FROM inversion WHERE date_complete IS NULL", nativeQuery = true)
        List<InversionEntity> findAllNoTerminate();

        @Query(value = "SELECT * FROM inversion WHERE date_complete IS NOT NULL", nativeQuery = true)
        List<InversionEntity> findAllTerminate();

        @Query(value = "SELECT i.id_inversion AS idInversion, i.name_investor AS nameInvestor, i.date_record AS dateRecord, ROUND(SUM(t.lot * t.cost), 2) AS costoTela "
                        +
                        "FROM inversion i " +
                        "LEFT JOIN tela t " +
                        "ON i.id_inversion = t.id_inversion " +
                        "WHERE i.date_complete IS NULL " +
                        "GROUP BY i.id_inversion, i.name_investor", nativeQuery = true)
        List<InversionProjection> findAllNotTerminateProjection();

        @Query(value = """
                        SELECT
                        i.id_inversion AS idInversion,
                        i.name_investor AS nameInvestor,
                        i.date_record AS dateRecord,
                        (SELECT IFNULL(SUM(t.lot * t.cost), 0)
                        FROM tela t
                        WHERE t.id_inversion = i.id_inversion) AS costoTela,
                        (SELECT IFNULL(SUM(p.lot), 0)
                        FROM product p
                        WHERE p.id_inversion = i.id_inversion) AS lotProduction,
                        IFNULL(c.service_pole, 0) AS servicePole,
                        IFNULL((c.cost_perbutton + c.service_button + c.service_cuttape), 0) AS confeccionAddCost,
                        (SELECT IFNULL(SUM(p.lot * p.price_unitary), 0)
                        FROM product p
                        WHERE p.id_inversion = i.id_inversion) AS ingresos
                        FROM inversion i
                        LEFT JOIN confection c ON i.id_confection = c.id_confection
                        WHERE i.date_complete IS NOT NULL;
                        """, nativeQuery = true)
        List<InversionTerminateProjection> findAllTerminateProjection();

        @Query(value = """
                        SELECT
                        COUNT(DISTINCT i.id_inversion) AS numeroInversionesCompletadas,
                        COUNT(DISTINCT p.product_id) AS numeroProductos
                        FROM inversion i
                        LEFT JOIN
                        product p ON i.id_inversion = p.id_inversion
                        WHERE i.date_complete IS NOT NULL;
                                """, nativeQuery = true)
        CountInvestmenProduction findCountInvestProduct();

        @Query(value = """
                        SELECT
                        i.id_inversion AS idInversion,
                        i.date_complete AS dateRecord,
                        (SELECT IFNULL(SUM(t.lot * t.cost), 0)
                        FROM tela t
                        WHERE t.id_inversion = i.id_inversion) AS costoTela,
                        (SELECT IFNULL(SUM(p.lot), 0)
                        FROM product p
                        WHERE p.id_inversion = i.id_inversion) AS lotProduction,
                        IFNULL(c.service_pole, 0) AS servicePole,
                        IFNULL((c.cost_perbutton + c.service_button + c.service_cuttape), 0) AS confeccionAddCost,
                        (SELECT IFNULL(SUM(p.lot * p.price_unitary), 0)
                        FROM product p
                        WHERE p.id_inversion = i.id_inversion) AS ingresos
                        FROM inversion i
                        LEFT JOIN confection c ON i.id_confection = c.id_confection
                        WHERE i.date_complete IS NOT NULL
                        ORDER BY i.date_complete;
                        """, nativeQuery = true)
        List<InversionDateProjection> findAllTerminateDateProjection();

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
