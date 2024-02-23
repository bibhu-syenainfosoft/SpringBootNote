package com.example.demo.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;

//@Component
public class DataInsertRunner implements CommandLineRunner {

	@Autowired
	private BookRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.saveAll(Arrays.asList(new Book(100,"C",230.0),
				new Book(100,"C",230.0),
				new Book(101,"CPP",530.0),
				new Book(103,"Java",650.0),
				new Book(104,"C#",800.0),
				new Book(106,"Python",900.0)));
	    System.out.println("Data Inserted");
		}

}
