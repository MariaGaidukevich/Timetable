package com.example.demo.DTO;

import com.example.demo.enums.Subjects;
import com.example.demo.model.Grade;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.List;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class TeacherDTO {
    private long id;
    private String name;
    private String middlename;
    private Subjects subject;
    private String passCard;
    private List<Grade> grades;
}
