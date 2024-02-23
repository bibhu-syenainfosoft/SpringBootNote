package com.example.demo.processor;

import org.springframework.batch.item.ItemProcessor;

public class MyItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("FROM ITEM PROCESSOR");
		return null;
	}



}
