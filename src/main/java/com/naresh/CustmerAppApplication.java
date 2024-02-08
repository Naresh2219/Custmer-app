package com.naresh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.naresh")
public class CustmerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustmerAppApplication.class, args);
	}

}
