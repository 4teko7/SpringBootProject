package com.teko7.entities;

public class UserEntity {

	int id;
	String firstname;
	String lastname;
	String username;
	String age;
	String school;
	String department;
	String password;
	String passwordConfirm;
	
	

	

	public UserEntity() {
		super();
	}
	
	public UserEntity(String username) {
		super();
		this.username = username;
	}
	
	

	public UserEntity(String firstname, String lastname, String username) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
	}
	
	public UserEntity(String firstname, String lastname, String username, String password, String age, String school,
			String department) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.age = age;
		this.school = school;
		this.department = department;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserEntity(int id, String firstname, String lastname, String username, String password, String age, String school,
			String department) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.age = age;
		this.school = school;
		this.department = department;
	}
	
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password
				+ ", age=" + age + ", school=" + school + ", department=" + department + "]";
	}
}
