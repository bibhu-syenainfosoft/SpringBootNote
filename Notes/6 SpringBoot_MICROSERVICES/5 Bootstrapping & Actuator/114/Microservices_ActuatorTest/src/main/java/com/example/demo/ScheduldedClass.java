package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduldedClass {
	
	@Scheduled(cron="0 0 9 * * *")
	public void display() {
		System.out.println("Hello");
	}

}
