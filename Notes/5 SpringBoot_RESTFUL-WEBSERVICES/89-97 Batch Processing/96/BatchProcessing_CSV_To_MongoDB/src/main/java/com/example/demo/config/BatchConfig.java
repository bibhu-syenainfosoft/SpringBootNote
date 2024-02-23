package com.example.demo.config;

import java.net.MalformedURLException;

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
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

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

	@Autowired
	private MongoTemplate mongoTemplate;
	//3. ItemWriter Obj
	@Bean
	public ItemWriter<Product> writer(){
		MongoItemWriter<Product> writer=new MongoItemWriter<>();
		writer.setTemplate(mongoTemplate);
		writer.setCollection("products");
		return writer;
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
