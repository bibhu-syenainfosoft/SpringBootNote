package com.example.demo;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class myRest {
	
	private Logger log = LoggerFactory.getLogger(myRest.class);
	
	@RequestMapping("/pay")
	@HystrixCommand(fallbackMethod = "doDummyPayment",
	commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "6000"),
	}) 
	
	public String doPayment() {
		log.info("Process Started...");
		if(new Random().nextInt(10)<15) {
			throw new RuntimeException("Dummy Exception");
		}
		log.info("Process Finished...");
		return "Success";
	}
	
	public String doDummyPayment() {
		log.info("FFROM DUMMY PAYMENT SERVICE");
		return "Please try after sometime...";
	}

}
