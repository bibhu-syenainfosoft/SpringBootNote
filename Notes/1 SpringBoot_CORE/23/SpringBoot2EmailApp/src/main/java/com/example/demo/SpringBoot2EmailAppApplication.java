package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringBoot2EmailAppApplication {
	
//	@Autowired
//	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2EmailAppApplication.class, args);
	}
//	@EventListener(ApplicationReadyEvent.class)
//    public void sendEmail() {
//		emailSenderService.sendEmail("bibhudattabehera523@gmail.com","This is the body of the email", "This is the subject");
//	}

}
