package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;

public class DataUtil {
	
	public static String[] display() throws IOException {
		FileInputStream fi = new FileInputStream("C:\\Users\\bibhu\\OneDrive\\Desktop\\About_me_some_Imp_things\\11_SpringBoot & Microservices\\Notes\\SpringBootNote\\Notes\\6 SpringBoot_MICROSERVICES\\6 Active MQs\\118\\abc.txt");
		byte[] bt = new byte[fi.available()];
		fi.read(bt);
		String message = new String(bt);
		fi.close();
		String[] arr = message.split(",");
		return arr;
	}

}
