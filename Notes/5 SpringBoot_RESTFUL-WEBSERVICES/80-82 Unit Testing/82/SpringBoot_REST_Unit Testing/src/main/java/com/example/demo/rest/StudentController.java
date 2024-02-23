package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/rest/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/save")
	public ResponseEntity<String> SaveStudent(@RequestBody Student s){
		Integer id=service.SaveStudent(s);
		return new ResponseEntity<String>("Student "+id+" Saved",HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Student>> GetStudentList(){
		List<Student> list=service.GetStudents();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}

	@DeleteMapping("remove/{id}")
	public ResponseEntity<String> DeleteStudent(@PathVariable Integer id){
		service.deleteStudent(id);
		return ResponseEntity.ok("Record "+id+" Deleted..");
	}

	@PutMapping("update/{id}")
	public ResponseEntity<String> UpdateStudent(@PathVariable Integer id,@RequestBody Student s){
		if(service.existsById(id)) {
			s.setProdId(id);
			service.updateStudent(s);
			return ResponseEntity.ok("Record "+id+" Updated..");
		}
		else {
			throw new StudentNotFoundException("Student "+id+" does not exist to Update.");
		}
	}

	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<Student> GetStudentById(@PathVariable Integer id){
		if(service.existsById(id)) {
		Student stu=service.GetStudentById(id);
		return new ResponseEntity<Student>(stu,HttpStatus.OK);
		}
		else {
			throw new StudentNotFoundException("Student "+id+" does not exist to Fetch.");
		}
	}


}
