package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
public Integer SaveStudent(Student s);
public List<Student> GetStudents();
}
