package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer eid;

	private String ename;
	private String email;

	private Double esal;
	private String dept;

	private Double hra;
	private Double da;

	public Employee(Integer eid, String ename, String email, Double esal, String dept, Double hra, Double da) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.esal = esal;
		this.dept = dept;
		this.hra = hra;
		this.da = da;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getEsal() {
		return esal;
	}

	public void setEsal(Double esal) {
		this.esal = esal;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Double getHra() {
		return hra;
	}

	public void setHra(Double hra) {
		this.hra = hra;
	}

	public Double getDa() {
		return da;
	}

	public void setDa(Double da) {
		this.da = da;
	}
	public Employee() {}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", esal=" + esal + ", dept="
				+ dept + ", hra=" + hra + ", da=" + da + "]";
	}
}