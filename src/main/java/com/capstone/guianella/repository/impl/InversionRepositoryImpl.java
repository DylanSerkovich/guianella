package com.capstone.guianella.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capstone.guianella.entity.InversionEntity;
import com.capstone.guianella.repository.InversionRepository;
import com.capstone.guianella.repository.database.InversionMySQLRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class InversionRepositoryImpl implements InversionRepository {

    private final InversionMySQLRepository repository;

    @Override
    public InversionEntity save(InversionEntity inversionEntity) {
        return repository.save(inversionEntity);
    }

    @Override
    public List<InversionEntity> findAllInversion() {
        return repository.findAll();
    }

    @Override
    public Optional<InversionEntity> findByInversion(int id) {
        return repository.findById(id);
    }

}
