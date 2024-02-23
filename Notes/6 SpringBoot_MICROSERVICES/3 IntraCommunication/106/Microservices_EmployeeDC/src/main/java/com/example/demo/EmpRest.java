package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpRest {
	
	@GetMapping("/register")
	public ResponseEntity<String> getEmpInfo()
	{
		return ResponseEntity.ok("From Employee APP");
	}

}
