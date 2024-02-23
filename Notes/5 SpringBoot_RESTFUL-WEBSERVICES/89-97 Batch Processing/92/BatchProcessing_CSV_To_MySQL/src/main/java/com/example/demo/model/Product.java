package com.example.demo.model;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Integer prodId;
	private String prodName;
	private Double prodCost;
	private Double prodDisc;
	private Double prodGst;
}

//Dependencies:
//MySQL,Spring Batch,Lombok