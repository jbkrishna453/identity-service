package com.apartmentmanagement.identity.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class UserPassword implements Serializable {
    private String userPassword;
}
