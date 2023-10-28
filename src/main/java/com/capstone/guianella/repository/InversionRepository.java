package com.capstone.guianella.repository;

import java.util.List;
import java.util.Optional;

import com.capstone.guianella.entity.InversionEntity;

public interface InversionRepository {

    InversionEntity save(InversionEntity inversionEntity);

    List<InversionEntity> findAllInversion();

    List<InversionEntity> findAllNoTerminate();

    List<InversionEntity> findAllTerminate();

    Optional<InversionEntity> findByInversion(int id);
}
