package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	BookRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
//		Book b=repo.findByBname("C");
//		System.out.println(b);
//		
//		repo.findByBnameAndBid("CPP", 101).forEach(System.out::println);
		
		repo.findByData(100,600.0).forEach(System.out::println);
		
		

		
	}

}
