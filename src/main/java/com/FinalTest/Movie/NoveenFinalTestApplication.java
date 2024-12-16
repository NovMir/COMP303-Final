package com.FinalTest.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoConnectionDetails;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NoveenFinalTestApplication {
	@Autowired
	 private MongodbConnectionTest mongoTest;

	public static void main(String[] args) {
		SpringApplication.run(NoveenFinalTestApplication.class, args);
		}
	
	
	@PostConstruct
		    public void init() {
		        System.out.println("Testing MongoDB Connection...");
		        mongoTest.testConnection();
	}

}
