package com.task.ClusteredDataWarehouse.handler;

import com.task.ClusteredDataWarehouse.common.ResponseEnvelop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.task.ClusteredDataWarehouse.common.Constants.REJECTED;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseEnvelop> handleException(Exception ex) {
        log.error("Internal Server Error: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseEnvelop.create(REJECTED, ex.getMessage()));
    }

    @ExceptionHandler(DealException.class)
    public ResponseEntity<ResponseEnvelop> handleDealException(DealException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.badRequest().body(ResponseEnvelop.create(REJECTED, ex.getMessage()));
    }
}