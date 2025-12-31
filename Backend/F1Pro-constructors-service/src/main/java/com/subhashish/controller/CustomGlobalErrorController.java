package com.subhashish.controller;

import com.subhashish.dto.ErrorResponse;
import com.subhashish.exception.ResourceNotFoundException;
import com.subhashish.exception.ServiceLayerException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Date;

@ControllerAdvice
public class CustomGlobalErrorController implements ErrorController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorResponse err = new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value(), new Date());

        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handelIllegalArgumentException(IllegalArgumentException ex){
        ErrorResponse err = new ErrorResponse(ex.getMessage(),HttpStatus.CONTINUE.value(), new Date());

        return new ResponseEntity<>(err,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidJson(HttpMessageNotReadableException ex) {
        ErrorResponse error = new ErrorResponse(
                "Malformed JSON request. Please check your payload.",
                HttpStatus.BAD_REQUEST.value(),
                new Date()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ServiceLayerException.class)
    public ResponseEntity<ErrorResponse> handleServiceLayerException(ServiceLayerException ex){
        ErrorResponse err = new ErrorResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());

        return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExeception(Exception ex) {
        ErrorResponse err = new ErrorResponse("Unexpected error. Something went wrong. Please try again.",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());

        return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
