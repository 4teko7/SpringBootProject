package com.teko7.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teko7.database.Database;
import com.teko7.entities.TodoEntity;

public class TodoService {

	Connection myConn = null;
	PreparedStatement myStmt = null;
    ResultSet myRs = null;
	
	private Database getDatabase() {return new Database();}
	private Connection getConnection() throws Exception {return getDatabase().getConnection();}

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
}
