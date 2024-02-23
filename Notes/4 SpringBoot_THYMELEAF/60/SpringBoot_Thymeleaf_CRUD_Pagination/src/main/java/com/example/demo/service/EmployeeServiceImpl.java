package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo repo;
	
	@Override
	public Integer SaveEmployee(Employee ee) {
		double esal = ee.getEsal();
		double hra = esal * 20/100.0;
		double da = esal * 10/100.0;
		ee.setHra(hra);
		ee.setDa(da);
		ee = repo.save(ee);
		return ee.getEid();
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Employee editEmployee(Integer id) {
		Optional<Employee> optional=repo.findById(id);
		if(optional.isPresent()) {
			Employee employee=optional.get();
			return employee;
		}
		return null;
	}

	@Override
	public void updateEmployee(Employee ee) {
	 if(repo.existsById(ee.getEid())) {
		 double esal = ee.getEsal();
			double hra = esal * 20/100.0;
			double da = esal * 10/100.0;
			ee.setHra(hra);
			ee.setDa(da);
			repo.save(ee);
	 }
	 else {
			//throw EmployeeNotFoundException
		}
	}
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable) {
		Page<Employee> page=repo.findAll(pageable);
		return page;
	}
	
}
