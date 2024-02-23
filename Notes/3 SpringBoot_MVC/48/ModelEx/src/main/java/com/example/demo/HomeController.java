package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping(value="/show")
	public String display(Model m) {
		m.addAttribute("eid",101);
		m.addAttribute("ename","Bibhu");
		m.addAttribute("designation","Associate Member Technical-Java");
		m.addAttribute("esal",34500.0);
		return "HomePage";
	}

}
