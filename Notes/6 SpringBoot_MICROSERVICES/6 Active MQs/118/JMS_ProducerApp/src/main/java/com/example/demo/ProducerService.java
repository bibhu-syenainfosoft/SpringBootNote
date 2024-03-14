package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.TextMessage;

@Component
public class ProducerService implements CommandLineRunner {
	
	@Autowired
    private JmsTemplate jt;

	@Override
	public void run(String... args) throws Exception {
		
//		//Where to send
//		String destinationName = "dest1";
//		
//		//What to send
//		MessageCreator  messageCreator = (session) -> {
//		  TextMessage tm = session.createTextMessage("Sent to MOM");
//		  return tm;
//		};
//		
//		jt.send(destinationName,messageCreator);
		
	//=====================================================================	
		
//		jt.send("dest2",ses->ses.createTextMessage("FIRST JMS APP"));
//		System.out.println("DONE !!!");

    //=====================================================================	
		
		String[] str = DataUtil.display();
		
		for(String data:str) {
			Thread.sleep(2000);
			jt.send("dest2",ses->ses.createTextMessage(data));
			System.out.println("DONE !!!");
		}	
	}

}
