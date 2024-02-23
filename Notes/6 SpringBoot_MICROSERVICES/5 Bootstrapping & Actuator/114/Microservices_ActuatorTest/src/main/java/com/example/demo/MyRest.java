
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class MyRest {
	
	private RestTemplate rt;
	
	@GetMapping("/show")
	public String show() {
		return "Hello";
	}

}
