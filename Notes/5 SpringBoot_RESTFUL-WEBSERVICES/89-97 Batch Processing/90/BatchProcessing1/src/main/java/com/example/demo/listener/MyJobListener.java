package com.example.demo.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {
	
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Before String Job");
	}
	
	public void afterJob(JobExecution jobExecution) {
		System.out.println("After finishing Job");
	}


}
