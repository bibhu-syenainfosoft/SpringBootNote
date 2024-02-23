package com.example.demo.model;

import lombok.*;
@Data
public class Product {
	
	private Integer prodId;
	private String prodName;
	private Double prodCost;
	private Double prodDisc;
	private Double prodGst;
}

//Dependencies:
//Spring Batch,Lombok,Mongo,h2