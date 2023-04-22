package com.example.banksystem.exception.handler;

import com.example.banksystem.exception.NotFoundException;
import com.example.banksystem.util.constants.ExceptionTypes;
import com.example.banksystem.util.results.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResult<Object> handleNotFoundException(NotFoundException exception) {
        return new ExceptionResult<>(
                ExceptionTypes.Exception.NotFoundException,
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage());
    }
}
