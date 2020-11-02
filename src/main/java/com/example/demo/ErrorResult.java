package com.example.demo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO GTB-工程实践: - ErrorResult类应放在sub package内
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {
    private String message;
}

