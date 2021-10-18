package com.example.lesson_7.service;

import com.example.lesson_7.entity.Student;
import com.example.lesson_7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public void deleteByName(String name) {
        studentRepository.deleteStudentByName(name);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public Student findByName(String name) {
        return studentRepository.findStudentByName(name).orElseThrow();
    }
}
