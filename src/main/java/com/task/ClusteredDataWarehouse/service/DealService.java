package com.task.ClusteredDataWarehouse.service;

import com.task.ClusteredDataWarehouse.repository.DealRepository;
import com.task.ClusteredDataWarehouse.common.ResponseEnvelop;
import com.task.ClusteredDataWarehouse.common.validation.Validation;
import com.task.ClusteredDataWarehouse.dto.RequestDeal;
import com.task.ClusteredDataWarehouse.entity.DealEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.task.ClusteredDataWarehouse.common.Constants.*;

@Slf4j
@Service
public class DealService {

    private final DealRepository dealRepository;

    private final Validation validation;

    @Autowired
    public DealService(Validation validationService, DealRepository dealRepository) {
        this.dealRepository =dealRepository;
        this.validation = validationService;
    }

    public ResponseEnvelop process(RequestDeal requestDeal) {
        validation.validRequestDeal(requestDeal);
        return registerDeal(requestDeal);
    }

    private ResponseEnvelop registerDeal(RequestDeal requestDeal) {
            Optional<DealEntity> deal = dealRepository.findByRefNo(requestDeal.getRefNo());
            if (deal.isPresent()) {
                return ResponseEnvelop.create(REJECTED, REJECTED_DEAL);
            }
            DealEntity dealEntity = RequestDeal.toDealEntity(requestDeal);
            dealRepository.save(dealEntity);
            log.info("Inserted deal with reference: {}", dealEntity.getRefNo());
            return  ResponseEnvelop.create(SUCCESS, APPROVED_DEAL);
    }


}
