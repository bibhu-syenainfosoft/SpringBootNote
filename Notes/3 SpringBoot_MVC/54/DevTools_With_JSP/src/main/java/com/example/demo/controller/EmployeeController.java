package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/show")
	public String display() {
		return "FormPage";
	}
	@PostMapping("/register")
	public String display2(@ModelAttribute Employee e,Model m) {
		Integer id=service.SaveEmployee(e);
		String msg="Employee "+id+" Inserted.";
		m.addAttribute("msg", msg);
		return "FormPage";
	}
}
