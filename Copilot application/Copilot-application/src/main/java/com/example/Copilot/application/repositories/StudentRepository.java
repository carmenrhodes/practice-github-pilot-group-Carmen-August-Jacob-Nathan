package com.example.Copilot.application.repositories;

import com.example.Copilot.application.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
