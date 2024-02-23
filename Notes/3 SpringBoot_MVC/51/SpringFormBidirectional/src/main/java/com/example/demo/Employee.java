package com.example.demo;

import java.util.List;

public class Employee {

	private Integer empId;
	private String empName;
	private Double empSal;
	private String empPwd;
	private String empGen;
	private String empDept;
	private String empAddr;
	
	private List<String> empLang;
	private List<String> empProj;
	public Employee() {}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empPwd=" + empPwd
				+ ", empGen=" + empGen + ", empDept=" + empDept + ", empAddr=" + empAddr + ", empLang=" + empLang
				+ ", empProj=" + empProj + "]";
	}
	public Employee(Integer empId, String empName, Double empSal, String empPwd, String empGen, String empDept,
			String empAddr, List<String> empLang, List<String> empProj) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empPwd = empPwd;
		this.empGen = empGen;
		this.empDept = empDept;
		this.empAddr = empAddr;
		this.empLang = empLang;
		this.empProj = empProj;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	public String getEmpGen() {
		return empGen;
	}
	public void setEmpGen(String empGen) {
		this.empGen = empGen;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public List<String> getEmpLang() {
		return empLang;
	}
	public void setEmpLang(List<String> empLang) {
		this.empLang = empLang;
	}
	public List<String> getEmpProj() {
		return empProj;
	}
	public void setEmpProj(List<String> empProj) {
		this.empProj = empProj;
	}
	
}
