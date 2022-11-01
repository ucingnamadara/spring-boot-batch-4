package com.kawahedukasi.batch4;

import com.kawahedukasi.batch4.security.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class Batch4Application {

	public static void main(String[] args) {
		SpringApplication.run(Batch4Application.class, args);
	}

	@Bean
	public FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean(){
		FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		filterFilterRegistrationBean.addUrlPatterns("/peserta", "/peserta/*");
		filterFilterRegistrationBean.setFilter(authFilter);
		return filterFilterRegistrationBean;
	}
}
