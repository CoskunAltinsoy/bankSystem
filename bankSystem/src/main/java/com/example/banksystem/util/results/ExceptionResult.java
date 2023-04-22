package com.example.banksystem.util.results;

import java.time.LocalDate;

public class ExceptionResult<T> {
    private LocalDate timestamp;
    private String type;
    private Integer httpStatus;
    private T message;
    public ExceptionResult(String type, Integer httpStatus, T message) {
        timestamp = LocalDate.now();
        this.type = type;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
