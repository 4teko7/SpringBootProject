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


@RequestMapping("/database")
@Controller
public class Database {

	
	 Connection myConn = null;
	 PreparedStatement myStmt = null;
     ResultSet myRs = null;

     String dbUrl = "jdbc:mysql://localhost:3306/demospringapp?useSSL=false";  
     String user = "admin";
     String password = "password";
     
     public Connection getConnection() throws Exception { return DriverManager.getConnection(dbUrl, user, password);}
     
     @GetMapping("/start")
     public String startDatabase() {
    	

	     try {
//	    	 Class.forName("com.mysql.jdbc.Driver");
	         myConn = getConnection();
	         System.out.println("CONNECTION SUCCESSFULL !");
//	         myStmt = myConn.createStatement();
	         System.out.println("CONNECTION SUCCESSFULL !");
	         System.out.println("Inserting a new employee to database\n");
//	
	         myStmt = myConn.prepareStatement("Insert into todo" + "(title, completed)" + "values" + "(?,?)");
	         myStmt.setString(1, "TTT");
    		 myStmt.setBoolean(2, false);
	         System.out.println("AFTER EXECUTING");
	         myStmt.executeUpdate();
// 	         myRs = myStmt.executeQuery("select * from todo order by id");
//	         
//	
//	         while(myRs.next()) {
//	             System.out.println(myRs.getString("id") + ", " + myRs.getString("title"));
//	         }
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
	    	 if(object instanceof TodoEntity) {
	    		 saveTodo((TodoEntity)object);
	    	 }
    	 }catch(Exception e) {
    		 
    	 } 
     }
     
     
     public Object getById(String type,int theId) {
    	 try {
	    	 if(type == "todo") {
	    		return getTodoById(theId);
	    	 }
    	 }catch(Exception e) {
    		 
    	 } 
    	 return null;
     }
     
     public void delete(String type , int id) {
    	 try {
	    	 if(type == "todo") {
	    		 removeTodo(id);
	    	 }
    	 }catch(Exception e) {
    		 
    	 } 
     }
     
     
     public TodoEntity getTodoById(int theId) throws SQLException {
    	 try {
    		 myConn = getConnection();
    		 myStmt = myConn.prepareStatement("select * from todo where id = ?");
    		 myStmt.setInt(1, theId);
    		 
    		 ResultSet rs = myStmt.executeQuery();

    		 if(rs.next())
    			 return new TodoEntity(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getBoolean("completed"));
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
     
     public void saveTodo(TodoEntity todo) throws SQLException {
    	 try {
    		 System.out.println("INSIDE DATABASE : " + todo);
    		 myConn = getConnection();
    		 myStmt = myConn.prepareStatement("Insert into todo (title, content, completed) values (?,?,?)");
    		 myStmt.setString(1, todo.getTitle());
    		 myStmt.setString(2, todo.getContent());
    		 myStmt.setBoolean(3, false);
    		 myStmt.executeUpdate();
    		 
    	 }catch(Exception e) {
    		 System.out.println(e.getStackTrace());
    	 }finally{
    		 myConn.close();
    	 }
     }
     
     
     public void removeTodo(int id) throws SQLException {
    	 try {
    		 myConn = getConnection();
    		 myStmt = myConn.prepareStatement("delete from todo where id = ?");
    		 myStmt.setInt(1, id);
    		 myStmt.executeUpdate();
    		 
    	 }catch(Exception e) {
    		 System.out.println(e.getStackTrace());
    	 }finally{
    		 myConn.close();
    	 }
     }
     
     
     
     public List<TodoEntity> getAllTodos() { 
    	 List<TodoEntity> todos = new ArrayList<TodoEntity>();	
    	 TodoEntity entity = null;
    	 try {
			 myConn = getConnection();
			 String query = "select * from todo";
			 myStmt = myConn.prepareStatement(query);
			 ResultSet rs = myStmt.executeQuery(query);
			 while(rs.next()) {
				 entity = new TodoEntity(rs.getInt("id"),rs.getString("title"),rs.getString("content"),rs.getBoolean("Completed"));
				
				 todos.add(entity);
			 }
			 myConn.close();
			 
		 }catch(Exception e) {
			 e.getStackTrace();
		 }
		 return todos;
	 }
     
     
     
     
     
 }

