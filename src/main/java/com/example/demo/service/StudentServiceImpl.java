package com.example.demo.service;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.model.Grade;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GradeService gradeService;
    public final ObjectMapper mapper;


    @Override
    public void createStudent(StudentDTO studentDTO) {
        Student student = mapper.convertValue(studentDTO, Student.class);
        studentRepository.save(student);

    }

    @Override
    public void updateStudent(Long id, StudentDTO studentDTO) {
        if (studentRepository.existsById(id)) {
            Student student = mapper.convertValue(studentDTO, Student.class);
            student.setId(id);
            studentRepository.save(student);
        }


    }

    @Override
    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
    }

    @Override
    public StudentDTO readStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return mapper.convertValue(student, StudentDTO.class);

    }

    @Override
    public Student getStudent(Long scNumber) {
        return studentRepository.findByScNumber(scNumber).get();
    }

    @Override
    public void addStudentToGrade(Long scNumber, String name) {
     Student student=getStudent(scNumber);
     Grade grade = gradeService.getGrade(name);
     student.setGrade(grade);
     List<Student> students = grade.getStudents();
     students.add(student);
     grade.setStudents(students);
     studentRepository.save(student);
}}
