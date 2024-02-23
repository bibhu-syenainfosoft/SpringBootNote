package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	

	@GetMapping("/reg")
	public String showRegForm(Model model) {
		Employee e = new Employee();
		e.setEmpId(889);
		e.setEmpName("ABC");
		e.setEmpGen("Male");
		e.setEmpDept("QA");
		
		model.addAttribute("employee2", e);
		return "FormPage";
	}
	
	@PostMapping("/save")
	public String readData(
			@ModelAttribute Employee employee, 
			Model model)
	{
		model.addAttribute("emp",employee);
		return "HomePage";
	}
}