package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer prodId;
	
	private String prodCode;
	private Double prodCost;
	
	private Double prodGst;
	private Double prodDisc;
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public Double getProdCost() {
		return prodCost;
	}
	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}
	public Double getProdGst() {
		return prodGst;
	}
	public void setProdGst(Double prodGst) {
		this.prodGst = prodGst;
	}
	public Double getProdDisc() {
		return prodDisc;
	}
	public void setProdDisc(Double prodDisc) {
		this.prodDisc = prodDisc;
	}
	@Override
	public String toString() {
		return "Student [prodId=" + prodId + ", prodCode=" + prodCode + ", prodCost=" + prodCost + ", prodGst="
				+ prodGst + ", prodDisc=" + prodDisc + "]";
	}
	public Student(Integer prodId, String prodCode, Double prodCost, Double prodGst, Double prodDisc) {
		super();
		this.prodId = prodId;
		this.prodCode = prodCode;
		this.prodCost = prodCost;
		this.prodGst = prodGst;
		this.prodDisc = prodDisc;
	}
	public Student() {}
	
}
