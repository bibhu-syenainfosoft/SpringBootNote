package com.example.demo.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Book {
	@Id
	private String bid;
	@NonNull
	private String bname;
	@NonNull
	private Double bprice;
	
	private List<String> list;
	private Map<String, Integer> bno;
	
	private Customer customer;
	
	private List<Customer> custs;

}
