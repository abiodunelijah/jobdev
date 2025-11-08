package com.coder2client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception exception, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(
                    exception.getMessage(),
                    "INTERNAL SERVER ERROR",
                    request.getDescription(false), LocalDateTime.now() );
            return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(Exception exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                exception.getMessage(),
                "NOT FOUND",
                request.getDescription(false), LocalDateTime.now() );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
