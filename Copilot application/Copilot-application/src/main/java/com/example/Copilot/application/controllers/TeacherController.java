package com.example.Copilot.application.controllers;

import com.example.Copilot.application.models.TeacherModel;
import com.example.Copilot.application.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<TeacherModel> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public TeacherModel getTeacherById(@PathVariable Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @PostMapping
    public TeacherModel createTeacher(@RequestBody TeacherModel teacher) {
        return teacherRepository.save(teacher);
    }

    @PutMapping("/{id}")
    public TeacherModel updateTeacher(@PathVariable Long id, @RequestBody TeacherModel teacherDetails) {
        TeacherModel teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.setName(teacherDetails.getName());
            teacher.setSubject(teacherDetails.getSubject());
            return teacherRepository.save(teacher);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }
}