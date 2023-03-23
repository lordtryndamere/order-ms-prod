package com.liondevs.orders.ordersmsprod.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class DefaultExceptionAdvice extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(DefaultException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleConflict(
            DefaultException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        String httpStatusCode = Integer.toString(ex.getHttpStatus().value());
        bodyOfResponse.put("message",ex.getMessage());
        bodyOfResponse.put("code",httpStatusCode);
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), ex.getHttpStatus(), request);
    }
}
