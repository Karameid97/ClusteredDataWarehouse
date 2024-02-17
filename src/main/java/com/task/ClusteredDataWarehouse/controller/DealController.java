package com.task.ClusteredDataWarehouse.controller;

import com.task.ClusteredDataWarehouse.common.ResponseEnvelop;
import com.task.ClusteredDataWarehouse.dto.RequestDeal;
import com.task.ClusteredDataWarehouse.service.DealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DealController {
    @Autowired
    private DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping("/deal")
    public ResponseEntity<ResponseEnvelop> registerDeal(@RequestBody RequestDeal requestDeal) {
        log.info("deal details {}", requestDeal);
        ResponseEnvelop response = dealService.process(requestDeal);
        return ResponseEntity.ok(response);
    }


}
