package com.example.lesson_7.repository;



import com.example.lesson_7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    public void deleteStudentByName(String name);
    public Optional<Student> findStudentByName(String name);
}
