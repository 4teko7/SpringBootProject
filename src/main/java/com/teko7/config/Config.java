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
	
	
	String notEmpty;
	String sizeUserUsername;
	String duplicateUserUsername;
	String sizeUserPassword;
	String diffUserPasswordConfirm;
	
	public Config() {
		super();
		this.dbUrl = "jdbc:mysql://localhost:3306/demospringapp?useSSL=false";
		this.user = "admin";
		this.password = "password";
		
		this.notEmpty = "This field is required.";
		this.sizeUserUsername = "Please use between 6 and 32 characters.";
		this.duplicateUserUsername="Someone already has that username.";
		this.sizeUserPassword="Try one with at least 8 characters.";
		this.diffUserPasswordConfirm="These passwords don't match.";
	}
	
	
	
	public String getNotEmpty() {
		return notEmpty;
	}


	public void setNotEmpty(String notEmpty) {
		this.notEmpty = notEmpty;
	}


	public String getSizeUserUsername() {
		return sizeUserUsername;
	}


	public void setSizeUserUsername(String sizeUserUsername) {
		this.sizeUserUsername = sizeUserUsername;
	}


	public String getDuplicateUserUsername() {
		return duplicateUserUsername;
	}


	public void setDuplicateUserUsername(String duplicateUserUsername) {
		this.duplicateUserUsername = duplicateUserUsername;
	}


	public String getSizeUserPassword() {
		return sizeUserPassword;
	}


	public void setSizeUserPassword(String sizeUserPassword) {
		this.sizeUserPassword = sizeUserPassword;
	}


	public String getDiffUserPasswordConfirm() {
		return diffUserPasswordConfirm;
	}


	public void setDiffUserPasswordConfirm(String diffUserPasswordConfirm) {
		this.diffUserPasswordConfirm = diffUserPasswordConfirm;
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
