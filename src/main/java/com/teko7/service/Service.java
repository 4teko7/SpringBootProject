package com.teko7.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teko7.config.Config;
import com.teko7.databases.UserDatabase;
import com.teko7.entities.TodoEntity;
import com.teko7.entities.UserEntity;
import com.teko7.databases.TodoDatabase;

public class Service {
	
	private TodoDatabase getTodoDatabase() {return new TodoDatabase();}
	private UserDatabase getUserDatabase() {return new UserDatabase();}
	public Config getConfig() {return new Config();}
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
    ResultSet myRs = null;

    Config config = getConfig();
    
    
    
     public Connection getConnection() throws Exception { return DriverManager.getConnection(config.getDbUrl(), config.getUser(), config.getPassword());}
     
//     @GetMapping("/start")
     public String startDatabase() {
    	

	     try {
	         myConn = getConnection();
             myStmt = myConn.prepareStatement("Insert into todo" + "(title, completed)" + "values" + "(?,?)");
	         myStmt.setString(1, "TTT");
    		 myStmt.setBoolean(2, false);
	         System.out.println("AFTER EXECUTING");
	         myStmt.executeUpdate();

	     }
	
	     catch(Exception exc) {
	         exc.printStackTrace();
	     }
	
	     finally {
	         if (myRs != null) {
	        	 try {
					myConn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
	     }
     return "indexjsp";
     }

     
     public void save(Object object) {
    	 try {
	    	 if(object instanceof TodoEntity) {getTodoDatabase().saveTodo((TodoEntity)object);}
	    	 else if(object instanceof UserEntity) {getUserDatabase().saveUser((UserEntity)object);}
    	 }catch(Exception e) {
    		 
    	 } 
     }
     
     public Object getAll(String type) {
    	 try {
	    	 if(type == "todo") {return getTodoDatabase().getAllTodos();}
	    	 else if(type == "user") {return getUserDatabase().getAllUsers();}
	    	 
    	 }catch(Exception e) {
    		 
    	 } 
    	 return null;
    	 
     }
     
     public Object getById(String type,int theId) {
    	 try {
	    	 if(type == "todo") {return getTodoDatabase().getTodoById(theId);}
	    	 else if(type == "user") {return getUserDatabase().getUserById(theId);}
    	 }catch(Exception e) {
    		 
    	 } 
    	 return null;
     }
     
     public void delete(String type , int id) {
    	 try {
	    	 if(type == "todo") {getTodoDatabase().removeTodo(id);}
	    	 else if(type == "user") {getUserDatabase().removeUser(id);}
    	 }catch(Exception e) {
    		 
    	 } 
     }
     
     
     public Object getByUsername(String type,String username) {
    	 try {
	    	 if(type == "user") {return getUserDatabase().getUserByUsername(username);}
    	 }catch(Exception e) {
    		 
    	 } 
    	 return null;
     }
     
     
     
 }

