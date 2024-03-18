package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
	
	@Value("${my.app.topicname}")
	public String topic;
	 
	@Autowired
	private KafkaTemplate<String, String> template;
	
	public void send(String message) {
	    template.send(topic,message);
	}

}
