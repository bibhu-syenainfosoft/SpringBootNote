package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue
	private Integer eid;
	
	private String ename;
	private String email;
	
	private Double esal;
	private String dept;
	
	private Double hra;
	private Double da;

}
