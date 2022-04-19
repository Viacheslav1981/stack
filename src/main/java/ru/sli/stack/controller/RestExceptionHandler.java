package ru.sli.stack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class RestExceptionHandler {


    /*
    @ExceptionHandler
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

     */

    @ExceptionHandler
    public ResponseEntity<String> handleSQlException(SQLException e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }


    @ExceptionHandler
    public ResponseEntity<ValidationError> handleValidationError(MethodArgumentNotValidException e) {
        ValidationError validationError = new ValidationError(e.getBindingResult().getFieldErrors().get(0).getField(), e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);

    }


}
