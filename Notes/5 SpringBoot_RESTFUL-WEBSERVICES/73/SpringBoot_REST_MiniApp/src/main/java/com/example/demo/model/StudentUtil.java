package com.example.demo.model;

public class StudentUtil {
	public static void copyNonNullValues(Student db,Student request) {
		if(request.getProdCode()!=null) {
			db.setProdCode(request.getProdCode());
		}
		if(request.getProdCost()!=null) {
			db.setProdCost(request.getProdCost());
		}
		
	}

}
