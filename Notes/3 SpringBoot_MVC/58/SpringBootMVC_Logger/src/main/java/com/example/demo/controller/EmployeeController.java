package com.example.demo.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	private Logger log=LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String mainPage() {
		return "index";
	}
	@GetMapping("/showForm")
	public String display() {
		return "FormPage";
	}
	@PostMapping("/register")
	public String display2(@ModelAttribute Employee e,Model m) {
		log.info("ENTERED INTO SAVE EMPLOYEE METHOD");
		try {
			Integer id = service.SaveEmployee(e);
			log.info("EMPLOYEE SAVED");
			String msg = "Employee " + id + " Inserted";
			m.addAttribute("msg", msg);
		} catch (Exception e2) {
			log.error("UNABLE TO PROCESS SAVE EMPLOYEE {}",e2.getMessage());
			e2.printStackTrace();
		}
		log.info("ABOUT TO RETURN REPONSE FROM SAVE EMPLOYEE METHOD");
		return "FormPage";
	}
	@GetMapping("/delete")
	public String display4(@RequestParam Integer eid,Model m) {
		try {
			service.deleteEmployee(eid);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
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



