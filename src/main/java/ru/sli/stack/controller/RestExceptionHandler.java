package ru.sli.stack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<List<ValidationError>> handleValidationError(MethodArgumentNotValidException e) {
        int countErrors = 0;
        countErrors = e.getErrorCount();
        List<ValidationError> array = new ArrayList<>();
        for (int i = 0; i < countErrors; i++) {
            array.add(new ValidationError(e.getBindingResult().getFieldErrors().get(i).getField(), e.getBindingResult().getFieldErrors().get(i).getDefaultMessage()));
        }

        return new ResponseEntity<>(array, HttpStatus.BAD_REQUEST);
    }


}
