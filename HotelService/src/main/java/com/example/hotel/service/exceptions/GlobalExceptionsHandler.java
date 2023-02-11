package com.example.hotel.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> exceptionHandler(ResourceNotFoundException ex){
        Map<String, Object> map = new HashMap<>();
        map.put("exception", ex.getClass());
        map.put("message", ex.getMessage());
        map.put("cause", ex.getCause());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
