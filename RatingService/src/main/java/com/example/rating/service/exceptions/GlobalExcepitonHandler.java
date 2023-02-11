package com.example.rating.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExcepitonHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<Map<String, Object>> exceptionOccoured(ResourceNotFoundException ex){
        Map<String, Object> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("exception", ex.getClass());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

    }
}
