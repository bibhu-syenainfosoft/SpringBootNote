package com.example.demo.writer;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class MyItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> item) throws Exception {
		System.out.println("FROM ITEM WRITER");
		
	} 


}
