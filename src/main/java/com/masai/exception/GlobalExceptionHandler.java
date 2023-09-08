package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(Exception e, WebRequest w){
        MyErrorDetails details = new MyErrorDetails();
        details.setTime(LocalDateTime.now());
        details.setMessage(e.getMessage());
        details.setDetails(w.getDescription(false));
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<MyErrorDetails> studentExceptionHandler(StudentException ex, WebRequest w){
        MyErrorDetails details = new MyErrorDetails();
        details.setMessage(ex.getMessage());
        details.setTime(LocalDateTime.now());
        details.setDetails(w.getDescription(false));

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}
