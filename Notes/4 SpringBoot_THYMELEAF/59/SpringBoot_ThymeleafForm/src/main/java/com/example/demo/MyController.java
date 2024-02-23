package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class MyController {
	@GetMapping("/showForm")
	public String display1(Model m) {
		Employee employee=new Employee();
		employee.setEid(1901);
		employee.setEname("Bibhu");
		employee.setEsal(1234.0);
    	m.addAttribute("employee",employee);
		return "FormPage";
	}
	@PostMapping("/save")
	public String display2(@ModelAttribute Employee emp,Model m) {
		System.out.println(emp);
    	m.addAttribute("emp",emp);
		return "FormData";
	}
}
