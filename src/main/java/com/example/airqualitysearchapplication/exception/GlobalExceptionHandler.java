package com.example.airqualitysearchapplication.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException ex) {
        return ResponseEntity.status(ex.getStatus()).body(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", ex.getStatus().value(),
                        "error", ex.getStatus().getReasonPhrase(),
                        "message", ex.getMessage()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAnyException(Exception ex) {
        return ResponseEntity.status(500).body(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", 500,
                        "error", "Internal Server Error",
                        "message", "Something went wrong"
                )
        );
    }
}
