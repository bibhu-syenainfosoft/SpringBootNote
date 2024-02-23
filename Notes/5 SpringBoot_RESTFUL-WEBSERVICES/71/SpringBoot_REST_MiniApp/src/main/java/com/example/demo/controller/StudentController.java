package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
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

import com.ctc.wstx.shaded.msv_core.driver.textui.ReportErrorHandler;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
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
	
//	//@RequestMapping("/getStudentById/{id}")
//	@GetMapping("/{id}")
//	public ResponseEntity<Student> GetStudentById(@PathVariable Integer id){
//	  Student stu=service.GetStudentById(id);
//		return new ResponseEntity<Student>(stu,HttpStatus.OK);
//	}
	
	
	//@RequestMapping("/getStudentById/{id}")
		@GetMapping("/{id}")
		public ResponseEntity<?> GetStudentById(@PathVariable Integer id){
			ResponseEntity<?> responseEntity=null;
			try{
				Student stu=service.GetStudentById(id);
	            responseEntity=new ResponseEntity<Student>(stu,HttpStatus.OK);
			}
//			catch(StudentNotFoundException ee) {
//                 throw ee;
//			}
			catch (Exception e) {
				responseEntity=new ResponseEntity<String>("Unable to get Student:"+id,HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
		return responseEntity;	
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteStudent(@PathVariable Integer id){
	 service.deleteStudent(id);
		return ResponseEntity.ok("Record "+id+" Deleted..");
	}

	@PutMapping("/{id}")
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

}
