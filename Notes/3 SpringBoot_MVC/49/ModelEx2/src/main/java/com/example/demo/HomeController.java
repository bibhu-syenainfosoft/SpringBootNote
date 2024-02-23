package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping(value="/show")
	public String display(Model m) {
		Employee employee=new Employee();
		employee.setEid(100);
		employee.setEname("Bibhu");
		employee.setEsal(34500.0);
		m.addAttribute("emp",employee);
		
		List<String> lst=List.of("A","B","C","D");
		m.addAttribute("list",lst);
		
		List<Employee> lstEmp=Arrays.asList(
				new Employee(1901,"Kamal",34560.0),
				new Employee(1902,"Sahil",30560.0),
				new Employee(1903,"Dev",55560.0));
		m.addAttribute("empTable",lstEmp);
		return "HomePage";
	}

}
