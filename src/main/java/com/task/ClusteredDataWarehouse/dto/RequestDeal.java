package com.task.ClusteredDataWarehouse.dto;

import com.task.ClusteredDataWarehouse.entity.DealEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
public class RequestDeal {
    private String refNo;
    private String fromCurrency;
    private  String toCurrency;
    private BigDecimal amount;
    private String timestamp;


    public  static DealEntity toDealEntity(RequestDeal requestDeal){
          DealEntity dealEntity= new DealEntity();
          dealEntity.setRefNo(requestDeal.getRefNo());
          dealEntity.setFromCurrency(requestDeal.getFromCurrency());
          dealEntity.setToCurrency(requestDeal.getToCurrency());
          dealEntity.setAmount(requestDeal.getAmount());
          dealEntity.setTime(Timestamp.valueOf(requestDeal.getTimestamp()));
          return dealEntity;
    }
}
