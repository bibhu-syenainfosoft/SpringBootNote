package com.example.demo.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStorage {
	
   private List<String> lst = new ArrayList<>();
   
   public void add(String message) {
	   lst.add(message);
   }

   public String getAll() {
	  return lst.toString();
   }
		   
}
