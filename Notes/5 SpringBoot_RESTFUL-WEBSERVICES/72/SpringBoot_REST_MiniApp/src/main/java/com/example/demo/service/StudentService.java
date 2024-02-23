package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
public Integer SaveStudent(Student s);
public List<Student> GetStudents();
public Student GetStudentById(Integer id);
public void deleteStudent(Integer id);
public boolean existsById(Integer id);
public void updateStudent(Student st);
public Integer UpdateCode(Integer pid,String pcode);
}
