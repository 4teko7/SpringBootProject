package com.teko7.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.teko7.service.Service;
import com.teko7.entities.UserEntity;

public class UserDatabase {

	Connection myConn = null;
	PreparedStatement myStmt = null;
    ResultSet myRs = null;
	
	private Service getService() {return new Service();}
	private Connection getConnection() throws Exception {return getService().getConnection();}
	
	public UserEntity getUserById(int theId) throws SQLException {
   	 try {
   		 myConn = getConnection();
   		 myStmt = myConn.prepareStatement("select * from users where id = ?");
   		 myStmt.setInt(1, theId);
   		 
   		 ResultSet rs = myStmt.executeQuery();

   		 if(rs.next())
   			 return new UserEntity(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("age"),rs.getString("school"),rs.getString("department"));
   		 else
   			 return null;
   		 
   	 }catch(Exception e) {
   		 System.out.println(e.getStackTrace());
   		 System.out.println("execute Query HAtasi !");
   		 System.exit(1);
   	 }finally{
   		 myConn.close();
   	 }
   	 return null;
    }

	public void saveUser(UserEntity user) throws SQLException {
   	 try {
   		 myConn = getConnection();
   		 if(user.getId() > 0) {
   			 myStmt = myConn.prepareStatement("update users set firstname=?, lastname=? , username=? , password=? , age=? , school=? , department=? where id=?");
   			 myStmt.setInt(8, user.getId());
   		 }
   		 else{
   			 myStmt = myConn.prepareStatement("Insert into users (firstname, lastname, username, password, age,school,department) values (?,?,?,?,?,?,?)");
   		 
   		 }
   		
   		 myStmt.setString(1, user.getFirstname());
   		 myStmt.setString(2, user.getLastname());
   		 myStmt.setString(3, user.getUsername());
   		 myStmt.setString(4, user.getPassword());
   		 myStmt.setString(5, user.getAge());
   		 myStmt.setString(6, user.getSchool());
   		 myStmt.setString(7, user.getDepartment());
   		 
   		 
   		 myStmt.executeUpdate();
   		 
   	 }catch(Exception e) {
   		 System.out.println("EXCEPTION");
   		 e.getStackTrace();
   	 }finally{
   		 myConn.close();
   	 }
    }

	public List<UserEntity> getAllUsers() { 
   	 List<UserEntity> users = new ArrayList<UserEntity>();	
   	 UserEntity entity = null;
   	 try {
			 myConn = getConnection();
			 String query = "select * from users";
			 myStmt = myConn.prepareStatement(query);
			 ResultSet rs = myStmt.executeQuery(query);
			 while(rs.next()) {
				 entity = new UserEntity(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("age"),rs.getString("school"),rs.getString("department"));
				System.out.println(entity);
				 users.add(entity);
			 }
			 myConn.close();
			 
		 }catch(Exception e) {
			 e.getStackTrace();
		 }
		 return users;
	 }


	
	public UserEntity getUserByUsername(String username) throws SQLException {
	   	 try {
	   		 myConn = getConnection();
	   		 myStmt = myConn.prepareStatement("select * from users where username = ?");
	   		 myStmt.setString(1, username);
	   		 
	   		 ResultSet rs = myStmt.executeQuery();

	   		 if(rs.next())
	   			 return new UserEntity(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("age"),rs.getString("school"),rs.getString("department"));
	   		 else
	   			 return null;
	   		 
	   	 }catch(Exception e) {
	   		 System.out.println(e.getStackTrace());
	   		 System.out.println("execute Query HAtasi !");
	   		 System.exit(1);
	   	 }finally{
	   		 myConn.close();
	   	 }
	   	 return null;
	    }
	
	
	public void removeUser(int id) throws SQLException {
   	 try {
   		 myConn = getConnection();
   		 myStmt = myConn.prepareStatement("delete from users where id = ?");
   		 myStmt.setInt(1, id);
   		 myStmt.executeUpdate();
   		 
   	 }catch(Exception e) {
   		 System.out.println(e.getStackTrace());
   	 }finally{
   		 myConn.close();
   	 }
    }

}
