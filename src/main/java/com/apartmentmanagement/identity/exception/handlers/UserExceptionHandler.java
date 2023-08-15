package com.apartmentmanagement.identity.exception.handlers;

import com.apartmentmanagement.identity.exception.exceptions.UserExistException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<String> userExists(UserExistException exception){
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(exception.getMessage());
    }
}
