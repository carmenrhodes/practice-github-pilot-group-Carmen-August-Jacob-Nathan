package com.example.Copilot.application.controllers;

import com.example.Copilot.application.models.StudentModel;
import com.example.Copilot.application.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public StudentModel getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public StudentModel createStudent(@RequestBody StudentModel student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public StudentModel updateStudent(@PathVariable Long id, @RequestBody StudentModel studentDetails) {
        StudentModel student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setGrade(studentDetails.getGrade());
            return studentRepository.save(student);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}