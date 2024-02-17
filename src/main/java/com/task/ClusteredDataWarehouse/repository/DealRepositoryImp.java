package com.task.ClusteredDataWarehouse.repository;

import com.task.ClusteredDataWarehouse.entity.DealEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DealRepositoryImp implements DealRepository {

    private final DealJpaRepository dealJpaRepository;


    public DealRepositoryImp(DealJpaRepository dealJpaRepository) {
        this.dealJpaRepository = dealJpaRepository;
    }

    @Override
    public void save(DealEntity entity) {
        dealJpaRepository.save(entity);
    }

    @Override
    public Optional<DealEntity> findByRefNo(String refNo) {
        return dealJpaRepository.findByRefNo(refNo);
    }

    @Override
    public void deleteAll() {
        dealJpaRepository.deleteAll();
    }
}
