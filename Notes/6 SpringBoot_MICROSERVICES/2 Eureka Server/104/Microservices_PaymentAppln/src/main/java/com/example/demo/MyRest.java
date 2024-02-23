package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class MyRest {
	
	@RequestMapping("/payment")
	public ResponseEntity<String> validatePayment(){
		return ResponseEntity.ok("Payment Success");
	}

}
