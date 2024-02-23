package com.example.demo;

import java.util.List;

public class Employee {
	private Integer eid;
	private String ename;
	private Double esal;
	private String empGen;
	private String empDept;
	private String empAddr;
	
	private List<String> empLang;
	private List<String> empProj;
	
	private String empColor;
	private String empDte;
	private String empTme;
	private String empFile;
	public Integer getEid() {
		return eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getEsal() {
		return esal;
	}
	public void setEsal(Double esal) {
		this.esal = esal;
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
	public String getEmpColor() {
		return empColor;
	}
	public void setEmpColor(String empColor) {
		this.empColor = empColor;
	}
	public String getEmpDte() {
		return empDte;
	}
	public void setEmpDte(String empDte) {
		this.empDte = empDte;
	}
	public String getEmpTme() {
		return empTme;
	}
	public void setEmpTme(String empTme) {
		this.empTme = empTme;
	}
	public String getEmpFile() {
		return empFile;
	}
	public void setEmpFile(String empFile) {
		this.empFile = empFile;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", empGen=" + empGen + ", empDept="
				+ empDept + ", empAddr=" + empAddr + ", empLang=" + empLang + ", empProj=" + empProj + ", empColor="
				+ empColor + ", empDte=" + empDte + ", empTme=" + empTme + ", empFile=" + empFile + "]";
	}
	public Employee(Integer eid, String ename, Double esal, String empGen, String empDept, String empAddr,
			List<String> empLang, List<String> empProj, String empColor, String empDte, String empTme, String empFile) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.empGen = empGen;
		this.empDept = empDept;
		this.empAddr = empAddr;
		this.empLang = empLang;
		this.empProj = empProj;
		this.empColor = empColor;
		this.empDte = empDte;
		this.empTme = empTme;
		this.empFile = empFile;
	}
	public Employee() {}
	
}
