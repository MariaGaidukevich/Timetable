package com.example.demo.controllers;

import com.example.demo.DTO.TeacherDTO;
import com.example.demo.service.TeacherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@Tag(name="Учителя")
public class TeacherController {
  private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    void createClass(@RequestBody TeacherDTO teacherDTO){
        teacherService.createTeacher(teacherDTO);
    }
    @PutMapping("{id}")
    void updateClass(@PathVariable (name="id")Long id, @RequestBody TeacherDTO teacherDTO){
        teacherService.updateTeacher(id,teacherDTO);
    }
    @DeleteMapping("{id}")
    void deleteClass(@PathVariable (name="id")Long id){
        teacherService.deleteTeacher(id);
    }
    @GetMapping("{id}")
    TeacherDTO readClass(@PathVariable(name="id")Long id){
        return teacherService.readTeacher(id);
    }
    @PostMapping("/grade")
    void orderTeacherToGrade(@RequestParam String passCard,@RequestParam String name){
        teacherService.orderTeacherToGrade(passCard,name);
    }

}
