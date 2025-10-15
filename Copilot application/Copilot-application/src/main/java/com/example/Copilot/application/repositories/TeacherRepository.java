package com.example.Copilot.application.repositories;

import com.example.Copilot.application.models.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {
}
