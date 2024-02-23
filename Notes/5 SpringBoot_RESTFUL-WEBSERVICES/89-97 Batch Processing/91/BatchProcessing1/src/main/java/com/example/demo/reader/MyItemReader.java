package com.example.demo.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class MyItemReader implements ItemReader<String> {

	String[] data = {"Welcome","To","Syena","Infosoft","PVT. LTD"};
	int count=0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(count<=data.length-1) {
			return data[count++];
		}
		else {
			count=0;
		}
		return null;
	}

}
