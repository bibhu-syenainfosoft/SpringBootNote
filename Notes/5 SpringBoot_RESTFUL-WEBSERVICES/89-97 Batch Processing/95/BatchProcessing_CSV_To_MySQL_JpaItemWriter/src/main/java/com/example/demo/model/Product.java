package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;
@Data
@Entity
public class Product {
	@Id       //if inside db id the table is created with primary key prodod then exception will show here
	private Integer prodId;
	private String prodName;
	private Double prodCost;
	private Double prodDisc;
	private Double prodGst;
}

//Dependencies:
//MySQL,Spring Batch,Lombok,Spring Data JPA