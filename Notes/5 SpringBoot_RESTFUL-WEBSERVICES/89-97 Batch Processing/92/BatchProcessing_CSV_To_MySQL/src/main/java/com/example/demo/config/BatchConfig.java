package com.example.demo.config;

import java.net.MalformedURLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.demo.listener.MyJobListener;
import com.example.demo.model.Product;
import com.example.demo.processor.MyItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	//1. ItemReader Obj
	@Bean
	public ItemReader<Product> reader() throws MalformedURLException{
		//JDK7 Collections type inference - Empty<> operator.
		FlatFileItemReader<Product> fReader=new FlatFileItemReader<>();
		fReader.setResource(new ClassPathResource("product.csv"));
		//fReader.setResource(new FileSystemResource("d:/abcd/product.csv")); //if the file is available in your local directory
		//fReader.setResource(new UrlResource("http://abcd.cm/mydata/product.csv"));
		
		//read data line by line
		fReader.setLineMapper(new DefaultLineMapper<>() {{
			//tokenize data and provides names for one line
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames("prodId","prodName","prodCost");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
				setTargetType(Product.class);
			}});
		}});
		return fReader;
	}

	//2. ItemProcessor Obj
	@Bean
	public ItemProcessor<Product,Product> processor(){
		return new MyItemProcessor();
	}

	//3. ItemWriter Obj
	@Bean
	public JdbcBatchItemWriter<Product> writer(){
		JdbcBatchItemWriter<Product> writer=new JdbcBatchItemWriter<>();
		writer.setDataSource(ds());
		writer.setSql("INSERT INTO PRODUCT(PID,PNAME,PCOST,PDISC,PGST) VALUES(:prodId,:prodName,:prodCost,:prodDisc,:prodGst)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		return writer;
	}
	@Bean
	public DataSource ds() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bibhu");
		ds.setUsername("root");
		ds.setPassword("jilucse@2002");
		return ds;
	}
	
	//4. JobListener Obj
	@Bean
	public JobExecutionListener listener(){
		return new MyJobListener();
	}
	

	//5. StepBuilderFactory Autowired
	@Autowired
	@Lazy
	private StepBuilderFactory sbf;
	
	//6. Configuration Step Object
	@Bean
	public Step stepA() throws MalformedURLException {
		return sbf.get("stepA")
				.<Product,Product>chunk(3)
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
