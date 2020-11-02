package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

// TODO GTB-工程实践: - Spring MVC异常处理类的包路径前缀应和Controller保持一致
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
        String message = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(message);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    // TODO GTB-知识点: - ResponseStatusException为框架内置异常，不需要使用自定义的ExceptionHandler来处理
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResult> handle(ResponseStatusException ex) {
        String message = ex.getReason();
        ErrorResult errorResult = new ErrorResult(message);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}