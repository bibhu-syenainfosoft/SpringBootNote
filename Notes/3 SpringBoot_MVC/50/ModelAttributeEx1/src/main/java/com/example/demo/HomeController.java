package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping(value="/showForm")
	public String display() {
		return "FormPage";
	}
	@PostMapping(value="register")
	public String display2(@ModelAttribute Employee emp,Model m) {
		System.out.println(emp);
		m.addAttribute("employee",emp);
		return "HomePage";
	}
}