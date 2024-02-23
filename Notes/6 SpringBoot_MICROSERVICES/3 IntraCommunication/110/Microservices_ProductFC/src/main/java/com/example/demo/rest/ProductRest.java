package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.VendorConsumer;
import com.example.demo.model.Vendor;

@RestController
@RequestMapping("/product")
public class ProductRest {
	
	@Autowired
	private VendorConsumer consumer;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Vendor vendor)
	{	
		String body = "From Product=>";
		String resp = consumer.saveVendor (vendor).getBody();
		return ResponseEntity.ok(body+" | "+ resp);	
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id)
	{	
		String body = "From Product=>";
		return ResponseEntity.ok(body+ " Deleted Successfully:"+id);	
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyProduct(@RequestBody Vendor vendor)
	{	
		String body = "From Product=>";
		ResponseEntity<String> responseEntity = consumer.modifyVendor(vendor);
		return ResponseEntity.ok(body+" | "+responseEntity.getBody());	
	}


}
