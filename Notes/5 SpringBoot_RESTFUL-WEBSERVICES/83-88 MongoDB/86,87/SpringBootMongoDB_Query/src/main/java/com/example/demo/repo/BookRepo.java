package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Book;

public interface BookRepo extends MongoRepository<Book, Integer> {

	//	//select * from book where bname=?
	//	@Query("{bname: ?0}")
	//	Book findByBname(String bname);
	//	
	//	//select * from book where bname=? and bid=? 
	//	@Query("{bname: ?0, bid: ?1}")
	//	List<Book> findByBnameAndBid(String bname,Integer bid);
	//	
	//	//select * from book where bid>100 and bprice<=800 
	//	@Query("{bid : {$gt : ?0}, bprice : {$lte : ?1} }") //variable name must be same 
	//	List<Book> findByData(Integer bid,Double bprice);

	//select * from book where bid=100 or bprice<=600 
	//@Query("{$or : [{bid : ?0 }, {bprice : {$lte : ?1}} ]}") 
	@Query("{$and : [{bid : ?0 }, {bprice : {$lte : ?1}} ]}")
	List<Book> findByData(Integer bid,Double bprice);






}
