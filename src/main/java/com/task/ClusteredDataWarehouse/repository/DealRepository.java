package com.task.ClusteredDataWarehouse.repository;

import com.task.ClusteredDataWarehouse.entity.DealEntity;

import java.util.Optional;

public interface DealRepository {

    void save(DealEntity entity);


    Optional<DealEntity> findByRefNo(String refNo);


    void deleteAll();
}
