package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/show")
	public String display() {
		return "redirect:display?name=Bibhu_Syena";
	}
	@GetMapping("/display")
	public String display2(@RequestParam(value="name",required=false,defaultValue="Kamal") String nm,Model mm) {
		mm.addAttribute("name",nm);
		return "HomePage";
	}
}

