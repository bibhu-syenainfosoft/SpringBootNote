package com.example.demo.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.model.Product;

public class MyItemProcessor implements ItemProcessor<Product, Product> {

	@Override
	public Product process(Product item) throws Exception {
	
		//JDK#10 Local variable Type Inference 
		var cost = item.getProdCost(); 
		var discount = cost*(15/100.0);
		var gst = cost*(12/100.0);
		item.setProdDisc(discount);
		item.setProdGst(gst);
		return item;
	}
}
