package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	public Integer         SaveEmployee(Employee ee);
	public List<Employee>  getAllEmployees();
	public void            deleteEmployee(Integer id);
	public Employee        editEmployee(Integer id);     
	public void            updateEmployee(Employee ee);       
}
