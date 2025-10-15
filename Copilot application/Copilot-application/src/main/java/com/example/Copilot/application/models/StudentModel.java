package com.example.Copilot.application.models;

import jakarta.persistence.*;

@Entity
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int grade;
    public StudentModel() {
    }
    public StudentModel(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}


