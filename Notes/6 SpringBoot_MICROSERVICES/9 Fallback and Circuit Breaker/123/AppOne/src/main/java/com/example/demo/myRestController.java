package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class myRestController {
	
	private Logger log = LoggerFactory.getLogger(myRestController.class);
	
	@Autowired
	private RestTemplate rTemplate;
	
	@GetMapping("/showA")
	public String showA() {
		log.info("WELCOME TO SERVICE #1");
		String resp = rTemplate.getForObject("http://localhost:8082/showB", String.class);
		log.info("BACK TO SERVICE #1 {}",resp);
		return "Done1";
	}

}
