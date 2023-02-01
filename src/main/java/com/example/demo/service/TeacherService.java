package com.example.demo.service;


import com.example.demo.DTO.TeacherDTO;
import com.example.demo.model.Teacher;

public interface TeacherService {
        void createTeacher (TeacherDTO teacherDTO);
        void updateTeacher(Long id,TeacherDTO teacherDTO);
        void deleteTeacher(Long id);
        TeacherDTO readTeacher(Long id);
        Teacher getTeacher(String passCard);
        void orderTeacherToGrade(String passCard,String name);
}
