package com.task.ClusteredDataWarehouse.validation;

import com.task.ClusteredDataWarehouse.common.validation.ValidationService;
import com.task.ClusteredDataWarehouse.dto.RequestDeal;
import com.task.ClusteredDataWarehouse.handler.DealException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.task.ClusteredDataWarehouse.common.Constants.*;

public class ValidationServiceTest {

    @Test
    public void testInvalidRefNoRequestDeal() {
        assertion(INVALID_REF_NO,new RequestDeal("", "USD", "JOD", new BigDecimal(100), "2022-01-01 12:34:56"));
        assertion(INVALID_REF_NO,new RequestDeal(null, "USD", "JOD", new BigDecimal(100), "2022-01-01 12:34:56"));
    }



    @Test
    public void testInvalidFromCurrencyRequestDeal() {
        assertion(INVALID_FROM_CURRENCY,new RequestDeal("1", "uuu", "JOD", new BigDecimal(100), "2022-01-01 12:34:56"));
        assertion(INVALID_FROM_CURRENCY,new RequestDeal("1", "", "JOD", new BigDecimal(100), "2022-01-01 12:34:56"));
        assertion(INVALID_FROM_CURRENCY,new RequestDeal("1", null, "JOD", new BigDecimal(100), "2022-01-01 12:34:56"));

    }

    @Test
    public void testInvalidToCuurrencyRequestDeal() {
        assertion(INVALID_TO_CURRENCY,new RequestDeal("1", "USD", "jod", new BigDecimal(100), "2022-01-01 12:34:56"));
        assertion(INVALID_TO_CURRENCY, new RequestDeal("1", "USD", "", new BigDecimal(100), "2022-01-01 12:34:56"));
        assertion(INVALID_TO_CURRENCY,new RequestDeal("1", "USD", null, new BigDecimal(100), "2022-01-01 12:34:56"));
    }

    @Test
    public void testInvalidAmountRequestDeal() {
        assertion( INVALID_AMOUNT,new RequestDeal("1", "USD", "JOD", new BigDecimal(0), "2022-01-01 12:34:56"));
        assertion( INVALID_AMOUNT,new RequestDeal("1", "USD", "JOD", null, "2022-01-01 12:34:56"));
    }

    @Test
    public void testInvalidTimestampRequestDeal() {
        assertion( INVALID_TIMESTAMP,new RequestDeal("1", "USD", "JOD", new BigDecimal(100), null));
        assertion( INVALID_TIMESTAMP, new RequestDeal("1", "USD", "JOD", new BigDecimal(100), ""));
        assertion( INVALID_TIMESTAMP,new RequestDeal("1", "USD", "JOD", new BigDecimal(100), "2022-01-0 12:34:56"));
        assertion( INVALID_TIMESTAMP,new RequestDeal("1", "USD", "JOD", new BigDecimal(100), "2022-01-01A 12:34:56"));

    }


    private void assertion(String message,RequestDeal request) {
        ValidationService validationService = new ValidationService();
        DealException exception = Assertions.assertThrows(DealException.class, () -> validationService.validRequestDeal(request));
        Assertions.assertEquals(message, exception.getMessage());
    }

}
