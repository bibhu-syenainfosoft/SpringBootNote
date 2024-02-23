package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.VendorConsumer;
import com.example.demo.model.Vendor;

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
	
	@GetMapping("/info2")
	public ResponseEntity<String> getProductInfo2()
	{	
		System.out.println(consumer.getClass().getName());
		String body = "From Product=>";
		ResponseEntity<Vendor> responseEntity = consumer.getVendorInfo2();
		return ResponseEntity.ok(body+" | "+responseEntity.getBody());	
	}
	
	@GetMapping("/info3")
	public ResponseEntity<String> getProductInfo3()
	{	
		System.out.println(consumer.getClass().getName());
		String body = "From Product=>";
		ResponseEntity<String> responseEntity = consumer.getVendorInfo3(2);
		return ResponseEntity.ok(body+" | "+responseEntity.getBody());	
	}
	
	@GetMapping("/info4")
	public ResponseEntity<String> getProductInfo4()
	{	
		System.out.println(consumer.getClass().getName());
		String body = "From Product=>";
		ResponseEntity<List<Vendor>> responseEntity = consumer.getVendorInfo4();
		return ResponseEntity.ok(body+" | "+responseEntity.getBody());	
	}

}
