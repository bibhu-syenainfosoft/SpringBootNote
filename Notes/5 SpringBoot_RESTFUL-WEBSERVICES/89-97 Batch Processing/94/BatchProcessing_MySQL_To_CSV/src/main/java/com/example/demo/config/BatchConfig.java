package com.example.demo.config;

import java.net.MalformedURLException;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class User {
		private Integer uid;
		private String uname;
		private String password;
		private String urole;
	}


	@Bean
	public DataSource ds() 
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bibhu");
		ds.setUsername("root");
		ds.setPassword("jilucse@2002");
		return ds;
	}

	//1. ItemReader Obj
	@Bean
	public JdbcCursorItemReader<User> reader() throws MalformedURLException
	{
		JdbcCursorItemReader<User> reader=new JdbcCursorItemReader<>();

		//Db connection
		reader.setDataSource(ds());
		//Data Fetching
		reader.setSql("SELECT UID,UNAME,PASSWORD,UROLE FROM USER");
		//Converting to Object
		reader.setRowMapper((rs,rowNum)-> new User(
				rs.getInt("uid"),
				rs.getString("uname"),
				rs.getString("password"),
				rs.getString("urole"))
				);
		return reader;
	}

	//2. ItemProcessor Obj
	@Bean
	public ItemProcessor<User,User> processor(){
		//		return item->item;
		//		return (item)->item;
		//		return item->{
		//			return item;
		//		};
		return new ItemProcessor<User, User>() {

			@Override
			public User process(User item) throws Exception {
				return item;
			}
		};
	}

	//3. ItemWriter Obj
	@Bean
	public FlatFileItemWriter<User> writer(){
		FlatFileItemWriter<User> writer=new FlatFileItemWriter<>();

		//File name+location
		writer.setResource(new FileSystemResource("C:/Users/bibhu/OneDrive/Desktop/About_me_some_Imp_things/11_SpringBoot/Notes/SpringBootNote/Notes/5 SpringBoot_RESTFUL-WEBSERVICES/89-97 Batch Processing/94/users.csv"));
		//convert object to Line
		writer.setLineAggregator(new DelimitedLineAggregator<>() {{
			setDelimiter(",");
			//read data from object based on the variable name
			setFieldExtractor(new BeanWrapperFieldExtractor<>() {{
				setNames(new String[] {"uid","uname","password","urole"});
			}});
		}});
		return writer;
	}

	//4. JobListener Obj
	@Bean
	public JobExecutionListener listener(){
		return new JobExecutionListener() {

			private long startTime;

			@Override
			public void beforeJob(JobExecution jobExecution) {
				startTime=System.currentTimeMillis();
				System.out.println("Batch Processing Started"+startTime);
				System.out.println("Batch Status:"+jobExecution.getStatus());
			}

			@Override
			public void afterJob(JobExecution jobExecution) {
				System.out.println("Batch Processing Finished");
				System.out.println("Batch Status:"+jobExecution.getStatus());
				Long endTime=System.currentTimeMillis();
				System.out.println("Time taken to finish job:"+(endTime-startTime));
			}

		};
	}


	//5. StepBuilderFactory Autowired
	@Autowired
	@Lazy
	private StepBuilderFactory sbf;

	//6. Configuration Step Object
	@Bean
	public Step stepA() throws MalformedURLException {
		return sbf.get("stepA")
				.<User,User>chunk(3)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	//7. JobBuilderFactory Autowired
	@Autowired
	@Lazy    //If reverse dependency happens then at that time we have to use @Lazy Annotations
	private JobBuilderFactory jbf;

	//8. Configuration Job Object
	@Bean
	public Job jobA() throws MalformedURLException {
		return jbf.get("stepA")
				.listener(listener())
				.incrementer(new RunIdIncrementer())
				.start(stepA())
				//.next(StepB())
				.build();		
	}	
}
