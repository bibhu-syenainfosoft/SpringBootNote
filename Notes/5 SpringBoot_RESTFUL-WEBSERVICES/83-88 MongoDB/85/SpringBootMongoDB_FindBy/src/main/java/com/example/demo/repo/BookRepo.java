package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Book;

public interface BookRepo extends MongoRepository<Book, Integer> {

	//select * from book where bname='?'
	public List<Book> findByBname(String bname);
	
	//select * from book where bid in(?,?,.......)
	public List<Book> findByBidIn(List<Integer> id);
	
}
