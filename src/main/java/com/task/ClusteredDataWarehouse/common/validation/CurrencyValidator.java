package com.task.ClusteredDataWarehouse.common.validation;

import lombok.extern.slf4j.Slf4j;

import java.util.Currency;

import static com.task.ClusteredDataWarehouse.common.Constants.*;

@Slf4j
public class CurrencyValidator {
    public static boolean isValidCurrency(String currencyCode) {
        try {
            Currency.getInstance(currencyCode);
            log.info(VALID_CURRENCY);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
