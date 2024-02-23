package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	private Integer prodId;
	
	private String prodCode;
	private Double prodCost;
	
	private Double prodGst;
	private Double prodDisc;
	
}
