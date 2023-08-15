package com.apartmentmanagement.identity.exception.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserExistException extends RuntimeException{
    private String message;
}
