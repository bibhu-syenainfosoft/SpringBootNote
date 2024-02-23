package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RestRunner implements CommandLineRunner {

	@Autowired
	private BookRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		Book b1=new Book("106","Java",990.0);
		repo.saveAll(Arrays.asList(
				new Book("100","C",230.0),
				new Book("102","CPP",430.0),
				new Book("1088","C#",900.0)
				));
		
		System.out.println("Book Data Inserted");
		
		System.out.println("Primary Key Values:"+b1.getBid());
		
		repo.findAll().forEach(System.out::println);
		}

}
