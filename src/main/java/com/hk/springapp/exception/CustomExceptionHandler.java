package com.hk.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler
{

    @ExceptionHandler(InvalidInputException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(InvalidInputException ex)
    {
        ErrorResponse error = new ErrorResponse(HttpStatus.LENGTH_REQUIRED.value(),ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.LENGTH_REQUIRED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(MethodArgumentNotValidException ex, WebRequest request)
    {

        ErrorResponse error = new ErrorResponse(HttpStatus.LENGTH_REQUIRED.value(),ex.getBindingResult().getFieldError().toString(), LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.LENGTH_REQUIRED);
    }
    @ExceptionHandler(Exception.class) //Global exception handling
    public final ResponseEntity<ErrorResponse> handleUnAuthenticException(Exception ex)
    {
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}