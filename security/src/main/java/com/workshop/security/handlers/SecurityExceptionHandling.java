package com.workshop.security.handlers;

import com.workshop.security.exceptions.UserExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class SecurityExceptionHandling {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleValidationArguments(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err ->
                errorMap.put(err.getField(), err.getDefaultMessage()));

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UserExistException.class})
    public ResponseEntity<?> handleUserExistException(UserExistException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
