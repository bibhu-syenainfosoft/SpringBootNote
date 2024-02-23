package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.listener.MyJobListener;
import com.example.demo.processor.MyItemProcessor;
import com.example.demo.reader.MyItemReader;
import com.example.demo.writer.MyItemWriter;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

	//1. ItemReader Obj
	@Bean
	public ItemReader<String> reader(){
		return new MyItemReader();
	}

	//2. ItemProcessor Obj
	@Bean
	public ItemProcessor<String,String> processor(){
		return new MyItemProcessor();
	}

	//3. ItemWriter Obj
	@Bean
	public ItemWriter<String> writer(){
		return new MyItemWriter();
	}
	
	//4. JobListener Obj
	@Bean
	public JobExecutionListener listener(){
		return new MyJobListener();
	}
	

	//5. StepBuilderFactory Autowired
	@Autowired
	private StepBuilderFactory sbf;
	
	//6. Configuration Step Object
	@Bean
	public Step stepA() {
		return sbf.get("StepA")
				.<String,String>chunk(3)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	//7. JobBuilderFactory Autowired
	@Autowired
	private JobBuilderFactory jbf;
	
	//8. Configuration Job Object
	@Bean
	public Job jobA() {
		return jbf.get("StepA")
				.listener(listener())
				.incrementer(new RunIdIncrementer())
				.start(stepA())
				//.next(StepB())
				.build();		
	}
	
	
	
	
	
	

}
