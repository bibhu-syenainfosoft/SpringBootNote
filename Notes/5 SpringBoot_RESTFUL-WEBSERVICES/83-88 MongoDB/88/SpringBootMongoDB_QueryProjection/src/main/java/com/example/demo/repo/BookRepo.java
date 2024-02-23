package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Book;

public interface BookRepo extends MongoRepository<Book, Integer> {

	//	//prints data in JSON format
	//	@Query(fields="{'bname':1, 'bid':0}" , value="{$and : [{bid : ?0 }, {bprice : {$lte : ?1}} ]}")
	//	List<String> findByData(Integer bid,Double bprice);


	//	//prints data in Object format
	//	@Query(fields="{'bname':1, 'bid':0}" , value="{$and : [{bid : ?0 }, {bprice : {$lte : ?1}} ]}")
	//	List<Book> findByData(Integer bid,Double bprice);

//	    @Query(value="{bname : ?0}" , count = true)
//      Integer getDataTotal(String bname);
	
//		@Query(fields="{ bname :1, bid : 0}" , value="{bprice : {$lte : ?0} }", sort= "{bname : 1}" ) //ASC
//		List<String> findByData(Double bprice);
	
//	    @Query(fields="{ bname :1, bid : 0}" , value="{bprice : {$lte : ?0} }", sort= "{bname : -1}" ) //DESC
//	    List<String> findByData(Double bprice);
	
//	    //Deleting data based on where condition
//	    @Query(value="{bprice : ?0}",delete=true)
//	    void deleteData(double bprice);
	
	    //prints data in Object format by avoiding null values
		@Query(fields="{'bname':1, 'bid':0}" , value="{bprice : {$lte : ?0} }")
		List<Book> findByData(Double bprice);
	    
	    






}
