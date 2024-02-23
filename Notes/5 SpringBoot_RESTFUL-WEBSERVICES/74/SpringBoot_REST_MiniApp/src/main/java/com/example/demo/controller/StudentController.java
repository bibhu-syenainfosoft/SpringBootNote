package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOG=LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService service;

	///@RequestMapping("/saveStudent")
//	@PostMapping
//	public ResponseEntity<String> SaveStudent(@RequestBody Student s){
//		Integer id=service.SaveStudent(s);
//		return new ResponseEntity<String>("Student "+id+" Saved",HttpStatus.OK);
//	}

	@PostMapping
	public ResponseEntity<String> saveStudent(
			@RequestBody Student s)
	{
		LOG.info("ENTERED INTO SAVESTUDENT METHOD");
		ResponseEntity<String> resp = null;
		try {
			Integer id =  service.SaveStudent(s);
			resp = new ResponseEntity<String>(
					new StringBuffer()
					.append("Student '")
					.append(id)
					.append("' saved")
					.toString(),
					HttpStatus.CREATED);  //201
			LOG.info(" PRODUCT SAVED WITH ID {} ", id);
		} catch (Exception e) {
			LOG.error(" UNABLE TO SAVE PRODUCT {} " , e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to Process Save Student", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		LOG.info(" ABOUT TO LEAVE SAVESTUDENT METHOD ");
		return resp;
	}



	//@RequestMapping("/getStudent")
	@GetMapping
	public ResponseEntity<List<Student>> GetStudentList(@RequestBody Student s){
		List<Student> list=service.GetStudents();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}

	//@RequestMapping("/getStudentById/{id}")
	@GetMapping("/{id}")
	public ResponseEntity<?> GetStudentById(@PathVariable Integer id){
		ResponseEntity<?> responseEntity=null;
		try {
			Student stu=service.GetStudentById(id);
			responseEntity=new ResponseEntity<Student>(stu,HttpStatus.OK);
		}
		catch (StudentNotFoundException ee) {
			throw ee;
		}
		catch (Exception e) {
			responseEntity=new ResponseEntity<String>("Unable to fetch the product",HttpStatus.INTERNAL_SERVER_ERROR);
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
