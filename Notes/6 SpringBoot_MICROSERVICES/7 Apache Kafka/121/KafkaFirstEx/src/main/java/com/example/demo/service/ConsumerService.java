package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.store.MessageStorage;

@Component
public class ConsumerService {
	
	
	@Autowired
	public MessageStorage mStorage;
	
	@KafkaListener(topics = "${my.app.topicname}",groupId = "groupId")
	public void addToStore(String message) {
		mStorage.add(message);
	}
	
}
