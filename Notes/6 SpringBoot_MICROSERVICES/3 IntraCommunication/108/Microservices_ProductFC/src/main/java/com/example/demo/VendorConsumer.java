package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("VENDOR-APP")
public interface VendorConsumer {
	
	@GetMapping("/vendor/info")
	public ResponseEntity<String> getVendorInfo();
}
