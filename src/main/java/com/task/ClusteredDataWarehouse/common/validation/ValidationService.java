package com.task.ClusteredDataWarehouse.common.validation;


import com.task.ClusteredDataWarehouse.dto.RequestDeal;
import com.task.ClusteredDataWarehouse.handler.DealException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.task.ClusteredDataWarehouse.common.Constants.*;
import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isBlank;

@Slf4j
@Service
public class ValidationService implements Validation {
    @Override
    public void validRequestDeal(RequestDeal requestDeal) {
        log.info(VALIDATE_REQUEST);
        validateCurrency(requestDeal.getFromCurrency(), INVALID_FROM_CURRENCY);
        validateCurrency(requestDeal.getToCurrency(), INVALID_TO_CURRENCY);
        validateAmount(requestDeal.getAmount());
        validateTimestamp(requestDeal.getTimestamp());
        validateRefNo(requestDeal.getRefNo());
    }

    private void validateCurrency(String currency, String errorMessage) {
        if (!CurrencyValidator.isValidCurrency(currency)) {
            throw new DealException(errorMessage);
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (isNull(amount) || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new DealException(INVALID_AMOUNT);
        }
    }

    private void validateTimestamp(String timestamp) {
        if (!TimestampValidator.isValidTimestamp(timestamp)) {
            throw new DealException(INVALID_TIMESTAMP);
        }
    }

    private void validateRefNo(String refNo) {
        if (isBlank(refNo)) {
            throw new DealException(INVALID_REF_NO);
        }
    }
}


