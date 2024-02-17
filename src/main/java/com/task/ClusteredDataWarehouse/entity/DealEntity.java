package com.task.ClusteredDataWarehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "deals")
public class DealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ref-no")
    private String refNo;

    @Column(name = "from-currency")
    private String fromCurrency;

    @Column(name = "to-currency")
    private String toCurrency;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "time")
    private Timestamp time;
}
