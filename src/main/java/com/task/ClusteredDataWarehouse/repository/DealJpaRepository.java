package com.task.ClusteredDataWarehouse.repository;

import com.task.ClusteredDataWarehouse.entity.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealJpaRepository extends JpaRepository<DealEntity, Long> {
 Optional<DealEntity> findByRefNo(String refNo);
}