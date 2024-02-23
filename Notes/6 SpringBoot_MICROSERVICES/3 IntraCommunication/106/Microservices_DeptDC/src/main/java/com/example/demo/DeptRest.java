package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptRest {
	
	@Autowired
	private EmpConsumer consumer;
	
	@GetMapping("/register")
	public ResponseEntity<String> getDeptInfo()
	{
		String empData = consumer.getEmpData();
		String body = "From Dept APP "+empData;
		
		return ResponseEntity.ok(body);
	}
}
