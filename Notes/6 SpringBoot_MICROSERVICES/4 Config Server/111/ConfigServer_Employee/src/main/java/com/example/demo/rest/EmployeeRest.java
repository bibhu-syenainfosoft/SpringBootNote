package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRest {
	
   @Value("${my.app.name}")
   private String appName;
   
   @GetMapping("/info")
   public ResponseEntity<String> empInfo(){
	   return ResponseEntity.ok("App Name:"+appName);
   }
}
