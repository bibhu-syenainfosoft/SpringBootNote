package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctc.wstx.shaded.msv_core.driver.textui.ReportErrorHandler;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.model.StudentUtil;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	///@RequestMapping("/saveStudent")
	@PostMapping
	public ResponseEntity<String> SaveStudent(@RequestBody Student s){
		Integer id=service.SaveStudent(s);
		return new ResponseEntity<String>("Student "+id+" Saved",HttpStatus.OK);
	}
	//@RequestMapping("/getStudent")
	@GetMapping
	public ResponseEntity<List<Student>> GetStudentList(@RequestBody Student s){
		List<Student> list=service.GetStudents();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	
	//@RequestMapping("/getStudentById/{id}")
	@GetMapping("/{id}")
	public ResponseEntity<Student> GetStudentById(@PathVariable Integer id){
	  Student stu=service.GetStudentById(id);
		return new ResponseEntity<Student>(stu,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteStudent(@PathVariable Integer id){
	 service.deleteStudent(id);
		return ResponseEntity.ok("Record "+id+" Deleted..");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> UpdateStudent(@PathVariable Integer id,@RequestBody Student s){
		 Student stu=service.GetStudentById(id);
		 StudentUtil.copyNonNullValues(stu, s);
		 service.updateStudent(s);
		 return ResponseEntity.ok("Record "+id+" Updated..");
	}
	@PatchMapping("/{code}/{id}")
	public ResponseEntity<String> UpdateCode(@PathVariable String code,@PathVariable Integer id){
		 service.UpdateCode(id, code);
		 return new ResponseEntity<String>("Product code "+code+" Updated..",HttpStatus.OK);
	}

}
