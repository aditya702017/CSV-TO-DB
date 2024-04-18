package com.Csv.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CsvToDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvToDbApplication.class, args);
		
		System.out.println("aa"); 
	}

}
