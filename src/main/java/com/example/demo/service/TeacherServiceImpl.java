package com.example.demo.service;

import com.example.demo.DTO.TeacherDTO;
import com.example.demo.model.Grade;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;
    private final GradeService gradeService;
    private final ObjectMapper mapper;

    @Override
    public void createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = mapper.convertValue(teacherDTO, Teacher.class);
        teacherRepository.save(teacher);

    }

    @Override
    public void updateTeacher(Long id, TeacherDTO teacherDTO) {
        if (teacherRepository.existsById(id)) {
            Teacher teacher = mapper.convertValue(teacherDTO, Teacher.class);
            teacher.setId(id);
            teacherRepository.save(teacher);
        }


    }

    @Override
    public void deleteTeacher(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
        }
    }

    @Override
    public TeacherDTO readTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return mapper.convertValue(teacher, TeacherDTO.class);

    }

    @Override
    public Teacher getTeacher(String passCard) {
        return teacherRepository.findBypassCard(passCard).get();
    }

    @Override
    public void orderTeacherToGrade(String passCard, String name) {
    Teacher teacher=getTeacher(passCard);
    Grade grade=gradeService.getGrade(name);
    List<Teacher> teachers=grade.getTeachers();
    teachers.add(teacher);
    grade.setTeachers(teachers);
    teacherRepository.save(teacher);
    }
}
