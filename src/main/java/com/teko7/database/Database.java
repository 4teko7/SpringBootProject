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
	    	 }else if(object instanceof UserEntity) {
	    		 saveUser((UserEntity)object);
	    	 }
    	 }catch(Exception e) {
    		 
    	 } 
     }
     
     public Object getAll(String type) {
    	 try {
	    	 if(type == "todo") {
	    		return getAllTodos();
	    	 }else if(type == "user") {
	    		 return getAllUsers();
	    	 }
	    	 
    	 }catch(Exception e) {
    		 
    	 } 
    	 return null;
    	 
     }
     
     
     
     public Object getById(String type,int theId) {
    	 try {
	    	 if(type == "todo") {return getTodoById(theId);}
	    	 else if(type == "user") {return getUserById(theId);}
    	 }catch(Exception e) {
    		 
    	 } 
    	 return null;
     }
     
     public void delete(String type , int id) {
    	 try {
	    	 if(type == "todo") {removeTodo(id);}
	    	 else if(type == "user") {removeUser(id);}
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
     
     public UserEntity getUserById(int theId) throws SQLException {
    	 try {
    		 myConn = getConnection();
    		 myStmt = myConn.prepareStatement("select * from users where id = ?");
    		 myStmt.setInt(1, theId);
    		 
    		 ResultSet rs = myStmt.executeQuery();

    		 if(rs.next())
    			 return new UserEntity(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("age"),rs.getString("school"),rs.getString("department"));
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
    		 
    		 if(todo.getId() > 0) {
    			 myStmt = myConn.prepareStatement("update todo set title=?, content=? , completed=? where id=?");
    			 myStmt.setInt(4, todo.getId());
    		 }
    		 else{
        		 myStmt = myConn.prepareStatement("Insert into todo (title, content, completed) values (?,?,?)");    		 
    		 }
    		 
    		 
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
     
     public void saveUser(UserEntity user) throws SQLException {
    	 try {
    		 myConn = getConnection();
    		 if(user.getId() > 0) {
    			 myStmt = myConn.prepareStatement("update users set firstname=?, lastname=? , username=? , age=? , school=? , department=? where id=?");
    			 myStmt.setInt(7, user.getId());
    		 }
    		 else{
    			 myStmt = myConn.prepareStatement("Insert into users (firstname, lastname, username, age,school,department) values (?,?,?,?,?,?)");
    		 
    		 }
    		
    		 myStmt.setString(1, user.getFirstname());
    		 myStmt.setString(2, user.getLastname());
    		 myStmt.setString(3, user.getUsername());
    		 myStmt.setString(4, user.getAge());
    		 myStmt.setString(5, user.getSchool());
    		 myStmt.setString(6, user.getDepartment());
    		 
    		 myStmt.executeUpdate();
    		 
    	 }catch(Exception e) {
    		 e.getStackTrace();
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
     
     
     public List<UserEntity> getAllUsers() { 
    	 List<UserEntity> users = new ArrayList<UserEntity>();	
    	 UserEntity entity = null;
    	 try {
			 myConn = getConnection();
			 String query = "select * from users";
			 myStmt = myConn.prepareStatement(query);
			 ResultSet rs = myStmt.executeQuery(query);
			 while(rs.next()) {
				 entity = new UserEntity(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("age"),rs.getString("school"),rs.getString("department"));
				System.out.println(entity);
				 users.add(entity);
			 }
			 myConn.close();
			 
		 }catch(Exception e) {
			 e.getStackTrace();
		 }
		 return users;
	 }
     
     
     
     
     
 }

