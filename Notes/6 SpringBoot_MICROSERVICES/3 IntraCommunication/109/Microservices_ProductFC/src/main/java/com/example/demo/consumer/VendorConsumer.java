package com.example.demo.consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Vendor;

@FeignClient("VENDOR-APP")
public interface VendorConsumer {
	
	@GetMapping("/vendor/info")
	public ResponseEntity<String> getVendorInfo();
	
	@GetMapping("/vendor/info2")
	public ResponseEntity<Vendor> getVendorInfo2();
	
	@GetMapping("/vendor/info3/{id}")
	public ResponseEntity<String> getVendorInfo3(@PathVariable("id") Integer id);
	
	@GetMapping("/vendor/info4")
	public ResponseEntity<List<Vendor>> getVendorInfo4();
}
