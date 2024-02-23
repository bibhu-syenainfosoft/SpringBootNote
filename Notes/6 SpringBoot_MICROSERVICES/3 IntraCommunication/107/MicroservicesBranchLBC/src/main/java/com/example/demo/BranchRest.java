package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class BranchRest {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/register")
	public ResponseEntity<String> getEmpInfo()
	{
		return ResponseEntity.ok("From Company Service=>"+port);
	}

}
