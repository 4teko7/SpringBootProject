package com.teko7.database;

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

import com.teko7.entities.TodoEntity;
import com.teko7.entities.UserEntity;
import com.teko7.services.TodoService;
import com.teko7.services.UserService;

public class Database {
	
	private TodoService getTodoService() {return new TodoService();}
	private UserService getUserService() {return new UserService();}
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
    ResultSet myRs = null;

    String dbUrl = "jdbc:mysql://localhost:3306/demospringapp?useSSL=false";  
    String user = "admin";
    String password = "password";
	


     public Connection getConnection() throws Exception { return DriverManager.getConnection(dbUrl, user, password);}
     
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
	    	 if(object instanceof TodoEntity) {getTodoService().saveTodo((TodoEntity)object);}
	    	 else if(object instanceof UserEntity) {getUserService().saveUser((UserEntity)object);}
    	 }catch(Exception e) {
    		 
    	 } 
     }
     
     public Object getAll(String type) {
    	 try {
	    	 if(type == "todo") {return getTodoService().getAllTodos();}
	    	 else if(type == "user") {return getUserService().getAllUsers();}
	    	 
    	 }catch(Exception e) {
    		 
    	 } 
    	 return null;
    	 
     }
     
     public Object getById(String type,int theId) {
    	 try {
	    	 if(type == "todo") {return getTodoService().getTodoById(theId);}
	    	 else if(type == "user") {return getUserService().getUserById(theId);}
    	 }catch(Exception e) {
    		 
    	 } 
    	 return null;
     }
     
     public void delete(String type , int id) {
    	 try {
	    	 if(type == "todo") {getTodoService().removeTodo(id);}
	    	 else if(type == "user") {getUserService().removeUser(id);}
    	 }catch(Exception e) {
    		 
    	 } 
     }
     
     
     
     
 }

