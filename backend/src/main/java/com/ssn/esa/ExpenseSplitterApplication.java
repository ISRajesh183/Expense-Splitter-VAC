package com.ssn.esa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages="com.ssn.esa")
@EnableMongoRepositories(basePackages="com.ssn.esa.repository")
public class ExpenseSplitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseSplitterApplication.class, args);
	}

}
