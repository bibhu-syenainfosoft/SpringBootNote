package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class MyController {
	@GetMapping("/show")
	public ResponseEntity<String> display(){
		return ResponseEntity.ok("Hii");
	}

}
