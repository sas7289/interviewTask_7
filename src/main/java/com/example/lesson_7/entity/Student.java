package com.example.lesson_7.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "students")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    @Id
    private UUID id;

    @PrePersist
    private void setId() {
        this.id = UUID.randomUUID();
    }

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;


    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student setAgeAndName(Student student) {
        this.name = student.getName();
        this.age = student.getAge();
        return this;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
