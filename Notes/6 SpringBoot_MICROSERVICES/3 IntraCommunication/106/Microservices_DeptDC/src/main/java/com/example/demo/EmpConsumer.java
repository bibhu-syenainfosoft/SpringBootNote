package com.example.demo;

import java.net.URI;
import java.util.List;

import org.bouncycastle.asn1.cmp.PKIStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmpConsumer {
	
	//1. Make DiscoveryClient Autowired
	@Autowired
	private DiscoveryClient client;
	
	public String getEmpData() {
		
		//2. Fetch List<SI> using producer service Id
		List<ServiceInstance> lst = client.getInstances("EMPLOYEE-APP");
		
		//3. Read one instance from list index#0
		ServiceInstance si = lst.get(0);
		
		//4. Read URI from SI
		URI uri = si.getUri();
		
		//Create and URL
		String url = uri+"/emp/register";
		
		//Use RestTemplate class to make a request to server
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> responseEntity = rt.getForEntity(url,String.class);
		String respBody = responseEntity.getBody();
		
		return respBody;
	}
	
	

}
