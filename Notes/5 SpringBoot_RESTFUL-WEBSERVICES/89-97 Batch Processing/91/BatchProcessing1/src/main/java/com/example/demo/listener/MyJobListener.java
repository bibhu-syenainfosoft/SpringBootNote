package com.example.demo.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {
	private long startTime;

	public void beforeJob(JobExecution jobExecution) {
		startTime=System.currentTimeMillis();
		System.out.println("Batch Processing Started"+startTime);
		System.out.println("Batch Status:"+jobExecution.getStatus());
	}

	public void afterJob(JobExecution jobExecution) {
		System.out.println("Batch Processing Finished");
		System.out.println("Batch Status:"+jobExecution.getStatus());
		Long endTime=System.currentTimeMillis();
		System.out.println("Time taken to finish job:"+(endTime-startTime));
	}
	


}
