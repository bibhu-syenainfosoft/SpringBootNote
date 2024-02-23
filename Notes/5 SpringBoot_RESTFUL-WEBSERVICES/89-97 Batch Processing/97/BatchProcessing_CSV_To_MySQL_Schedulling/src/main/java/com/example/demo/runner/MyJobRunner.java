package com.example.demo.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJobRunner {
	
	@Autowired
	private Job jobA;
	
	@Autowired
	private JobLauncher jobLauncher;

	@Scheduled(cron="0 48 9 * * *")
	public void MySchedullingRunner() throws Exception {
		System.out.println("RUNNING BATCH PROCESSING");
		
		JobParameters jobParameters=new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis())
				.toJobParameters();
	
		jobLauncher.run(jobA, jobParameters);

	}

}
