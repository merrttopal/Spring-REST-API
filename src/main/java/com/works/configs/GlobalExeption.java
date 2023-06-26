package com.works.configs;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeption {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid(MethodArgumentNotValidException exception){
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", false);
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : exception.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        hm.put("result", errors);
        return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }


}
