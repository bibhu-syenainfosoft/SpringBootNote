package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void run(String... args) throws Exception {
		
//		mongoTemplate.save(new Student(100,"Bibhu","Java"));
//		mongoTemplate.save(new Student(101,"Harish",".NET"));
//		mongoTemplate.save(new Student(102,"Sourav","Python"));
//		
//		mongoTemplate.findAll(Student.class).forEach(System.out::println);
		
		
		Query query=new Query();
		query.addCriteria(Criteria.where("sid").is(100));
		mongoTemplate.find(query,Student.class).forEach(System.out::println);
		
//		Update update=new Update();
//		update.set("sname", "Kamal");
//		update.set("scourse", "Angular");
//		Query query=new Query();
//		query.addCriteria(Criteria.where("sid").is(100));
//		mongoTemplate.findAndModify(query, update, Student.class);
//		System.out.println("Data Updated");
		
		//This is very less used in RealTime
		//JdbcTemplate
		//HibernateTemplate
		//JpaTemplate
		//MongoTemplate
		
		
		
		
		
		
	}

}
