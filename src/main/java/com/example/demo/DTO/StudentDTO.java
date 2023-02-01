package com.example.demo.DTO;

import com.example.demo.model.Grade;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StudentDTO {
    private String name;
    private String surname;
    private String middlename;

    private Long scNumber;
    private Grade grade;
}
