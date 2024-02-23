package com.example.demo.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.model.Customer;
import com.example.demo.repo.BookRepo;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private BookRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Book book=new Book();
	//	book.setBid("100");
		book.setBname("Python");
		book.setBprice(980.0);
		book.setList(List.of("A","B","C"));
		book.setBno(Map.of("k1",11,"k2",22));
		book.setCustomer(new Customer(199,"Cust1"));
		book.setCusts(List.of(new Customer(299,"Cust11"),
				new Customer(399,"Cust22")));
		
		repo.save(book);
		
		System.out.println("Book Data Inserted");
		//repo.deleteAll();
		repo.findAll().forEach(System.out::println);
		}

}
