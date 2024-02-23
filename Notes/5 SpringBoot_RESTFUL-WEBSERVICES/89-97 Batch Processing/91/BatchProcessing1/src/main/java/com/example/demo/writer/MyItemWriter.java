package com.example.demo.writer;

import java.util.List;

import org.springframework.batch.core.step.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class MyItemWriter implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("FROM WRITER CLASS:"+items);
	}

}
