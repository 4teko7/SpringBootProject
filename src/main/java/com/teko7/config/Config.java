package com.teko7.config;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"com.teko7"})


public class Config {
	
	String dbUrl;
	String user;
	String password;
	
	
	public Config() {
		super();
		this.dbUrl = "jdbc:mysql://localhost:3306/demospringapp?useSSL=false";
		this.user = "admin";
		this.password = "password";
	}


	public String getDbUrl() {
		return dbUrl;
	}


	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
}
