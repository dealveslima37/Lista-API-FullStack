package com.vfoprojects.listaapi.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.vfoprojects.listaapi.service.exceptions.ExistingItemException;
import com.vfoprojects.listaapi.service.exceptions.ItemNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ExistingItemException.class)
    public ResponseEntity<StandardError> existingitem(ExistingItemException e, HttpServletRequest request){
        
        StandardError err = new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());

        return new ResponseEntity<StandardError>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<StandardError> itemNotFound(ItemNotFoundException e, HttpServletRequest request){

        StandardError err = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());

        return new ResponseEntity<StandardError>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

        ValidationError error = new ValidationError(Instant.now(), HttpStatus.BAD_REQUEST.value(), "Erro de validação",
                request.getRequestURI());

        for(FieldError x : e.getBindingResult().getFieldErrors()){
            error.addError(x.getDefaultMessage());
        }

        return new ResponseEntity<StandardError>(error, HttpStatus.BAD_REQUEST);
    }


}
