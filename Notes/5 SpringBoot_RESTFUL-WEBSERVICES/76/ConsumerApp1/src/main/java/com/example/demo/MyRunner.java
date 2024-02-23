package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyRunner implements CommandLineRunner{
Logger log=LoggerFactory.getLogger(MyRunner.class);
	@Override
	public void run(String... args) throws Exception {
		RestTemplate rt=new RestTemplate();
		String url="http://localhost:8080/employee/show";
		ResponseEntity<String>  rEntity=rt.getForEntity(url, String.class);
		log.info("Status:{}",rEntity.getStatusCode());
		log.info("Status Code:{}",rEntity.getStatusCodeValue());
		log.info("Body:{}",rEntity.getBody());	
	}

}
