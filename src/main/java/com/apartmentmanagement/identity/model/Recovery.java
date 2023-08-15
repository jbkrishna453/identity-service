package com.apartmentmanagement.identity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recovery implements Serializable {
    private String question;
    private String answer;
}
