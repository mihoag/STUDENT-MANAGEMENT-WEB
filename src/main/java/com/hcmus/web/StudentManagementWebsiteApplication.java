package com.hcmus.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hcmus.web"})
public class StudentManagementWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementWebsiteApplication.class, args);
	}
}
