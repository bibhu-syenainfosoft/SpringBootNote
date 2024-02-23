package com.example.demo.config;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.demo.listener.MyJobListener;
import com.example.demo.model.Product;
import com.example.demo.processor.MyItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private MongoTemplate mongoTemplate;

	//1. ItemReader Obj
	@Bean
	@StepScope
	public ItemReader<Product> reader() throws MalformedURLException{
		//JDK7 Collections type inference - Empty<> operator.
		MongoItemReader<Product> reader=new MongoItemReader<>();
		HashMap<String, Sort.Direction> map=new HashMap<>();
		map.put("Product", Sort.Direction.DESC);
		Criteria expiredFiles=Criteria.where("prodId").gte(10);
		reader.setTemplate(mongoTemplate);
		reader.setSort(map);
		reader.setTargetType(Product.class);
        reader.setQuery(Query.query(expiredFiles).getQueryObject().toString());
		return reader;
	}

	//2. ItemProcessor Obj
	@Bean
	public ItemProcessor<Product,Product> processor(){
		return new MyItemProcessor();
	}

	@Bean
	public ItemWriter<Product> writer(){
		FlatFileItemWriter<Product> writer=new FlatFileItemWriter<>();

		writer.setResource(new FileSystemResource("C:/Users/bibhu/OneDrive/Desktop/About_me_some_Imp_things/11_SpringBoot/Notes/SpringBootNote/Notes/5 SpringBoot_RESTFUL-WEBSERVICES/89-97 Batch Processing/96/products.csv"));
		writer.setLineAggregator(new DelimitedLineAggregator<>() {{
			setDelimiter(",");
			setFieldExtractor(new BeanWrapperFieldExtractor<>() {{
				setNames(new String[] {"prodId","prodName","prodCost","prodDisc","prodGst"});
			}});
		}});
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
