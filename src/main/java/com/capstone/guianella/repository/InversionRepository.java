package com.capstone.guianella.repository;

import java.util.List;
import java.util.Optional;

import com.capstone.guianella.entity.InversionEntity;
import com.capstone.guianella.projections.InversionProjection;
import com.capstone.guianella.projections.InversionTerminateProjection;

public interface InversionRepository {

    InversionEntity save(InversionEntity inversionEntity);

    List<InversionEntity> findAllInversion();

    List<InversionEntity> findAllNoTerminate();

    List<InversionEntity> findAllTerminate();

    List<InversionProjection> findAllNoTerminateProjection();

    List<InversionTerminateProjection> findAllTerminateProjection();

    Optional<InversionEntity> findByInversion(int id);
}
