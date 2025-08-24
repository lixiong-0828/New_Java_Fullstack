package com.lixiong.pojo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // error for [400: parameter validation error]
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }
    // error for [404: ResourceNotFoundException]
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex , HttpServletRequest request){

        return new ResponseEntity<>("ResourceNotFoundException happened : "  + ex.getMessage(), HttpStatus.NOT_FOUND);

    }
    // error for [500: An unexpected error happened ]
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpectedException(Exception ex , HttpServletRequest request){
        return new ResponseEntity<>("An unexpected error happened :" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // error for [500: An unexpected error happened ]
    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<String> handleUnexpectedException(InvalidCredentialException ex ){
        return new ResponseEntity<>("403 An InvalidCredentialException error happened :" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
