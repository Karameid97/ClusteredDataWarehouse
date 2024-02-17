package com.task.ClusteredDataWarehouse.validation;

import com.task.ClusteredDataWarehouse.common.validation.CurrencyValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyValidationTest {

    @Test
    public void testInvalidCurrencyCode_InvalidCode_ReturnsFalse() {
        assertFalse(CurrencyValidator.isValidCurrency("UUU"));
        assertFalse(CurrencyValidator.isValidCurrency(null));
        assertFalse(CurrencyValidator.isValidCurrency(""));
    }

    @Test
    public void testValidCurrencyCode_ValidCode_ReturnsTrue(){
        assertTrue(CurrencyValidator.isValidCurrency("USD"));

    }
}
