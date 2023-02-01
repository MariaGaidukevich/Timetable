package com.example.demo.controllers;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Tag(name="Ученики")
@RequiredArgsConstructor
public class StudentController {
  private final StudentService studentService;

    @PostMapping
    void createClass(@RequestBody StudentDTO studentDTO){
        studentService.createStudent(studentDTO);
    }
    @PutMapping(value="{id}")
    void updateClass(@PathVariable (name="id")Long id, @RequestBody StudentDTO studentDTO){
        studentService.updateStudent(id,studentDTO);
    }
    @DeleteMapping(value="{id}")
    void deleteClass(@PathVariable (name="id")Long id){
        studentService.deleteStudent(id);
    }
    @GetMapping(value="{id}")
    StudentDTO readClass(@PathVariable(name="id")Long id){
        return studentService.readStudent(id);
    }

    @PostMapping("/grade")
    void addStudentToKlass(@RequestParam Long scNumber, @RequestParam String name){
        studentService.addStudentToGrade(scNumber,name);
    }





}
