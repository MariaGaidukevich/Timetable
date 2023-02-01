package com.example.demo.service;


import com.example.demo.DTO.StudentDTO;
import com.example.demo.model.Student;

public interface StudentService {
    void createStudent (StudentDTO studentDTO);
    void updateStudent(Long id,StudentDTO studentDTO);
    void deleteStudent(Long id);
   StudentDTO readStudent(Long id);
   Student getStudent(Long scNumber);
  void addStudentToGrade(Long scNumber,String name);


}
