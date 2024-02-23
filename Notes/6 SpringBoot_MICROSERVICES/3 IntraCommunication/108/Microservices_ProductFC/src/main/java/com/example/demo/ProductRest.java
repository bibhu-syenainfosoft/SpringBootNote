package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRest {
	
	@Autowired
	private VendorConsumer consumer;
	
	@GetMapping("/info")
	public ResponseEntity<String> getProductInfo()
	{	
		System.out.println(consumer.getClass().getName());
		String body = "From Product=>";
		ResponseEntity<String> responseEntity = consumer.getVendorInfo();
		return ResponseEntity.ok(body+" | "+responseEntity.getBody());	
	}

}
