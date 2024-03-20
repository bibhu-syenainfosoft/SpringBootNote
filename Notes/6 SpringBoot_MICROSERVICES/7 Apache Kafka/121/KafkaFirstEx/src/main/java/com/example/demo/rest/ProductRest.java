package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProductService;
import com.example.demo.store.MessageStorage;

@RestController
@RequestMapping("/kafka")
public class ProductRest {
	
	@Autowired
	public MessageStorage mStorage;
	
	@Autowired
	public ProductService psService;
	
	@GetMapping("/send")
	public String send(@RequestParam("msg") String message) {
		psService.send(message);  
		return "SENT:"+message;
	}

	@RequestMapping("/all")
	public String all() {
		return mStorage.getAll();
	}

}
