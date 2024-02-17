package com.task.ClusteredDataWarehouse.validation;

import com.task.ClusteredDataWarehouse.common.validation.TimestampValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimestampValidationTest {

    @Test
    public void testInvalidTimestamp_InvalidFormat_ReturnsFalse() {
        assertFalse(TimestampValidator.isValidTimestamp("2022-01-0 12:34:56"));
        assertFalse(TimestampValidator.isValidTimestamp(null));
        assertFalse(TimestampValidator.isValidTimestamp(""));
    }

    @Test
    public void testValidTimestamp_ValidFormat_ReturnsTrue() {
        assertTrue(TimestampValidator.isValidTimestamp("2022-01-01 12:34:56"));
    }
}
