package com.example.demo.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repo.BookRepo;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	BookRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.findByBname("C").forEach(System.out::println);
		repo.findByBidIn(Arrays.asList(100,101)).forEach(System.out::println);
		
	}

}
