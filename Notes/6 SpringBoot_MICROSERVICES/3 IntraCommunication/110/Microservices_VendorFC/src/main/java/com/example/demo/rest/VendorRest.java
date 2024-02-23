package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vendor;

@RestController
@RequestMapping("/vendor")
public class VendorRest {
	
	@Value("${server.port}")
	private String port;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveVendor(@RequestBody Vendor vendor)
	{
		return ResponseEntity.ok("Data is=>"+vendor+" Saved Successfully");
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteVendor(@PathVariable Integer id)
	{
		return ResponseEntity.ok("Data "+id+" is deleted Successfully");
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyVendor(@RequestBody Vendor vendor)
	{
		return ResponseEntity.ok("Data "+vendor+" is Modified");
	}
	
	

}
