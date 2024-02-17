package com.task.ClusteredDataWarehouse.repository;

import com.task.ClusteredDataWarehouse.entity.DealEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeDealRepository implements DealRepository {

    List<DealEntity> list = new ArrayList<>();

    @Override
    public void save(DealEntity entity) {
        list.add(entity);
    }

    @Override
    public Optional<DealEntity> findByRefNo(String refNo) {
        return list.stream()
                .filter(item -> item.getRefNo().equals(refNo))
                .findFirst();
    }

    @Override
    public void deleteAll() {
        list.clear();
    }
}
