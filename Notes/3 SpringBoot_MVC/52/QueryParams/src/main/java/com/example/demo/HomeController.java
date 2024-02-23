package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/show")
	public String showRegForm(@RequestParam(value="eid",required=false,defaultValue="100") int id,
			@RequestParam("ename") String name,
			@RequestParam("project") List<String> p,
			Model model) 
	{
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("project",p);
		return "HomePage";
	}
}



//http://localhost:1200/show?eid=100&ename=Bibhu&project=p1&project=p2