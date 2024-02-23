package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender; // HAS-A
	
	public boolean send(
			String to,
			String cc[],
			String bcc[],
			String subject,
			String text
			//Resource file
			) 
	{
		boolean flag = false;
		try {
			//1. Create Empty Message
			MimeMessage message = sender.createMimeMessage();
			
			//2. Use Helper class object -> message, isAttachmentExist?
			MimeMessageHelper helper = new MimeMessageHelper(message);
			
			//set details
			helper.setTo(to);
			helper.setSubject(subject);
			//helper.setText(text);//false-send as text
			helper.setText(text,true); //send as HTML data
			
			if(cc!=null && cc.length>0)
				helper.setCc(cc);
			if(bcc!=null && bcc.length>0)
				helper.setBcc(bcc);
		
//			if(file!=null)
//				helper.addAttachment(file.getFilename(), file);
			
			//3. send message
			sender.send(message);
			flag = true; //success
		} catch (Exception e) {
			flag = false; //failed
			e.printStackTrace();
		}
		
		return flag;
	}
}
