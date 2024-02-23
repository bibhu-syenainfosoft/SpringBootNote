package com.example.demo.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Vendor;

@FeignClient("VENDOR-APP")
public interface VendorConsumer {
	
	@PostMapping("vendor/save")
	public ResponseEntity<String> saveVendor(@RequestBody Vendor vendor);
	
	@GetMapping("vendor/delete/{id}")
	public ResponseEntity<String> deleteVendor(@PathVariable Integer id);
	
	@PutMapping("vendor/modify")
	public ResponseEntity<String> modifyVendor(@RequestBody Vendor vendor);
}
