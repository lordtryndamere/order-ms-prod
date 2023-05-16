package com.liondevs.orders.ordersmsprod.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends  RuntimeException{
    private String message;
    private HttpStatus httpStatus;
    public NotFoundException(String message, HttpStatus httpStatus){
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
