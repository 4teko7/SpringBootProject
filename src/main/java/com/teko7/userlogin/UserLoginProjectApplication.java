package com.teko7.userlogin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = {"com.teko7"})
//@ComponentScan(basePackages = {"com.teko7"})
@SpringBootApplication
@EnableAutoConfiguration
//@EnableJpaRepositories(basePackages="com.teko7.todo.repository")
//@EnableTransactionManagement
@EntityScan("com.teko7.entities")
public class UserLoginProjectApplication  {

//	extends SpringBootServletInitializer
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(UserLoginProjectApplication.class);
//	}
//	
	
	public static void main(String[] args) {
		SpringApplication.run(UserLoginProjectApplication.class, args);
	}

}
