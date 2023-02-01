package com.example.demo.service;

import com.example.demo.DTO.GradeDTO;
import com.example.demo.model.Grade;

public interface GradeService {
    void createGrade (GradeDTO gradeDTO);
    void updateGrade(Long id, GradeDTO gradeDTO);
    void deleteGrade(Long id);
    GradeDTO readGrade(Long id);
    Grade getGrade(String name);
}
