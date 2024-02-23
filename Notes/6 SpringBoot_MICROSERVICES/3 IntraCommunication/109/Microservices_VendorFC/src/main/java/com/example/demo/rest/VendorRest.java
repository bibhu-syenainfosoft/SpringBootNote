package com.example.demo.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vendor;

@RestController
@RequestMapping("/vendor")
public class VendorRest {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/info")
	public ResponseEntity<String> getVendorInfo()
	{
		return ResponseEntity.ok("From Vendor Service:"+port);
	}
	
	@GetMapping("/info2")
	public ResponseEntity<Vendor> getVendorInfo2()
	{
		return ResponseEntity.ok(new Vendor(1,"vendor1"));
	}
	
	@GetMapping("/info3/{id}")
	public ResponseEntity<String> getVendorInfo3(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok("Vendor By Id=>"+id);
	}
	
	@GetMapping("/info4")
	public ResponseEntity<List<Vendor>> getVendorInfo4()
	{
		return ResponseEntity.ok(Arrays.asList(new Vendor(1, "Vendor1"),new Vendor(2, "Vendor2"),
				new Vendor(3, "Vendor3"),new Vendor(4, "Vendor4")));
	}


}
