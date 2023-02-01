package com.example.demo.DTO;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class GradeDTO {

    private String name;
    private List<Teacher> teachers;
    private List<Student> students;
}
