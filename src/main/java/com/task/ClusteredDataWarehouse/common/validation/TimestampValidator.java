package com.task.ClusteredDataWarehouse.common.validation;

import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;

import static com.task.ClusteredDataWarehouse.common.Constants.*;
@Slf4j
public class TimestampValidator {

    public static boolean isValidTimestamp(String timestamp) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIMESTAMP_FORMAT);
            formatter.parse(timestamp);
            log.info(VALID_TIMESTAMP);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
