package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Student;

import jakarta.transaction.Transactional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Modifying
	@Transactional
	@Query("UPDATE Student SET prodCode=:pcode WHERE prodId=:pid ")
	public Integer updateCodeById(Integer pid,String pcode);

}
