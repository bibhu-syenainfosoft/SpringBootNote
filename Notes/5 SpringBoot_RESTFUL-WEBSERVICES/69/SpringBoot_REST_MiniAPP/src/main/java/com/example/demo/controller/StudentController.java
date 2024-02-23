package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
//@RequestMapping("/restapp")
public class StudentController {

	@Autowired
	private StudentService service;

	@RequestMapping("/saveStudent")
	public ResponseEntity<String> SaveStudent(@RequestBody Student s){
		Integer id=service.SaveStudent(s);
		return new ResponseEntity<String>("Student "+id+" Saved",HttpStatus.OK);
	}
	@RequestMapping("/getStudent")
	public ResponseEntity<List<Student>> GetStudentList(@RequestBody Student s){
		List<Student> list=service.GetStudents();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}

}
