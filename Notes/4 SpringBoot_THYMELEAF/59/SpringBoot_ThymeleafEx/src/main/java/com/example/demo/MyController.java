package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prod")
public class MyController {
	@GetMapping("/info")
	public String display1() {
		return "ProdInfo";
	}
	@GetMapping("/data")
	public String display2(Model m) {
		m.addAttribute("prodName", "TV");
		m.addAttribute("prodPrice", 23000);
		m.addAttribute("prodStatus", "Delivered");
		List<String> lst=List.of("A","B","C");
		m.addAttribute("list", lst);
		return "ProdData";
	}


}
