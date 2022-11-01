package com.kawahedukasi.batch4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Batch4Application {

	public static void main(String[] args) {
		SpringApplication.run(Batch4Application.class, args);
	}
}
