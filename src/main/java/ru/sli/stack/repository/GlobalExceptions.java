//package ru.sli.stack.repository;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//
//@ControllerAdvice
//public class GlobalExceptions {
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity globalExceptionHandler(Exception e) {
//
//        String message = "все сломалось";
//        return new ResponseEntity(message, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
//
//
