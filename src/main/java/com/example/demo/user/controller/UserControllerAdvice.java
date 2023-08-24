package com.example.demo.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handler(RuntimeException ex){

        //logging to centralize log
        ex.printStackTrace();

        ExceptionResponse response = new ExceptionResponse(
         "Hi Don't worry, be happy. the system will back soon");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
