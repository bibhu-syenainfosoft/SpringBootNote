package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo repo;
	
	@Override
	public Integer SaveStudent(Student s) {
		Double cost=s.getProdCost();

		var gst = cost * 12.0/100;
		var disc = cost * 20.0/100;
		 
		s.setProdDisc(disc);
		s.setProdGst(gst);
		s = repo.save(s);
		return s.getProdId() ;
	}

	@Override
	public List<Student> GetStudents() {
		return repo.findAll();
	}

}
