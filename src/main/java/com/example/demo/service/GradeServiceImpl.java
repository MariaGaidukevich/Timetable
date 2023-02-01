package com.example.demo.service;

import com.example.demo.DTO.GradeDTO;
import com.example.demo.repository.GradeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.model.Grade;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;
    private final ObjectMapper mapper;

    @Override
    public void createGrade(GradeDTO gradeDTO) {
        Grade grade = mapper.convertValue(gradeDTO, Grade.class);
        gradeRepository.save(grade);

    }

    @Override
    public void updateGrade(Long id, GradeDTO gradeDTO) {
        if (gradeRepository.existsById(id)) {
            Grade grade = mapper.convertValue(gradeDTO, Grade.class);
            grade.setId(id);
            gradeRepository.save(grade);
        }

    }

    @Override
    public void deleteGrade(Long id) {
        if (gradeRepository.existsById(id)) {
            gradeRepository.deleteById(id);
        }
    }
    @Override
    public GradeDTO readGrade(Long id) {
        Optional<Grade> grade = gradeRepository.findById(id);
        return mapper.convertValue(grade, GradeDTO.class);
    }
    @Override
    public Grade getGrade(String name) {
        return gradeRepository.findByName(name).get();
    }
}
