package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/showForm")
	public String display() {
		return "FormPage";
	}
	@PostMapping("/register")
	public String display2(@ModelAttribute Employee e,Model m) {
		Integer id=service.SaveEmployee(e);
		String msg="Employee "+id+" Inserted";
		m.addAttribute("msg", msg);
		return "FormPage";
	}
	@GetMapping("/empDetails")
	public String display3(@ModelAttribute Employee e,Model m) {
		List<Employee> lst=service.getAllEmployees();
		m.addAttribute("lstEmp", lst);
		return "EmployeeDetails";
	}
	@GetMapping("/delete")
	public String display4(@RequestParam Integer eid,Model m) {
		service.deleteEmployee(eid);
		m.addAttribute("message","Employee "+eid+" Deleted");
		List<Employee> lst=service.getAllEmployees();
		m.addAttribute("lstEmp", lst);
		return "redirect:empDetails";
	}
}

