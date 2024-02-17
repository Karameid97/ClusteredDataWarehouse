package com.task.ClusteredDataWarehouse.common;


public class ResponseEnvelop {
    private String status;
    private String message;

    public ResponseEnvelop(String status, String message) {
        this.status = status;
        this.message = message;
    }
    public static ResponseEnvelop create(String status, String message) {
        return new ResponseEnvelop(status, message);
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
