package com.example.demo.runner;

import java.util.List;

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

		//		List<String> list=repo.findByData(100,600.0);
		//		System.out.println(list);

		//		List<Book> list=repo.findByData(100,600.0);
		//		System.out.println(list);

		//		int count=repo.getDataTotal("CPP");
		//		System.out.println(count);

		//		List<String> list=repo.findByData(650.0);
		//		System.out.println(list);

		//		repo.deleteData(980.0);
		//		System.out.println("Data Deleted");

		repo.findByData(600.0)
		.stream()
		.map(bb->bb.getBname())
		.forEach(System.out::println);

	}

}
