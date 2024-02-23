package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecondController {
	
	@RequestMapping(value="/show")
	public String display() {
		return "HomePage";
	}
	
	@RequestMapping(value="/view")
	public String display2() {
		return "ViewAll";
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String display3() {
		return "Success";
	}



}
