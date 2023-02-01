package com.example.demo.controllers;

import com.example.demo.DTO.GradeDTO;
import com.example.demo.service.GradeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
@Tag(name="Школьные классы")
public class GradeController {
  private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    void createClass(@RequestBody GradeDTO gradeDTO){
        gradeService.createGrade(gradeDTO);
    }
    @PutMapping("{id}")
    void updateClass(@PathVariable (name="id")Long id, @RequestBody GradeDTO gradeDTO){
        gradeService.updateGrade(id, gradeDTO);
    }
    @DeleteMapping("{id}")
    void deleteClass(@PathVariable (name="id")Long id){
        gradeService.deleteGrade(id);
    }
    @GetMapping("{id}")
    GradeDTO readClass(@PathVariable(name="id")Long id){
        return gradeService.readGrade(id);
    }

}
