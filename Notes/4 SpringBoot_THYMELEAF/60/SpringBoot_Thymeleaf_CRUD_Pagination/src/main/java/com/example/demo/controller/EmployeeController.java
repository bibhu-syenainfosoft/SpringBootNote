package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String mainPage() {
		return "index";
	}
	@GetMapping("/showForm")
	public String display(Model m) {
		m.addAttribute("employee", new Employee());
		return "FormPage";
	}
	@PostMapping("/register")
	public String display2(@ModelAttribute Employee e,Model m) {
		Integer id=service.SaveEmployee(e);
		String msg="Employee "+id+" Inserted";
		m.addAttribute("msg", msg);
		m.addAttribute("employee", new Employee());
		return "FormPage";
	}
	@GetMapping("/delete")
	public String display4(@RequestParam Integer eid,Model m) {
		service.deleteEmployee(eid);
		m.addAttribute("message","Employee "+eid+" Deleted");
		List<Employee> lst=service.getAllEmployees();
		m.addAttribute("lstEmp", lst);
		return "redirect:all";
	}                                           
	@GetMapping("/edit")
	public String display5(@RequestParam Integer eid,Model m) {
		Employee employee=service.editEmployee(eid);
		m.addAttribute("emp",employee);
		return "EmpEdit";  
	}
	@PostMapping("/update")
	public String display6(@ModelAttribute Employee employee) {
		service.updateEmployee(employee);
		return "redirect:all";
	}
	@GetMapping("/all")
	public String display7(@PageableDefault(page=0,size=3)Pageable pageable,Model m) {
		Page<Employee> page=service.getAllEmployees(pageable);
		List<Employee> lst=page.getContent();
		m.addAttribute("list", lst);
		m.addAttribute("page", page);
		return "EmployeeDetails";
	}
}



