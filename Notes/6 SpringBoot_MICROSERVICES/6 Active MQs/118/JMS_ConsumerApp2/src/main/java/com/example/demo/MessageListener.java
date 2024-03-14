package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener  {
  
	@JmsListener(destination = "dest2")
	public void msgHolder(String txt) {
		System.out.println("Consumer2 received Data: "+txt);

	}

}
