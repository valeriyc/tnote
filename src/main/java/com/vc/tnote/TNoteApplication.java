package com.vc.tnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TNoteApplication.class, args);
	}
}
