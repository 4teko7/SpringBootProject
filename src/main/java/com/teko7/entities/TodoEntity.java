package com.teko7.entities;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown=true)
//@Entity
//@Table(name = "todo")
public class TodoEntity implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	
	int id;
	String title;
	String content;
	boolean completed;
	
	public TodoEntity() {
		super();
	}

	public TodoEntity(String title, boolean completed) {
		super();
		this.title = title;
		this.completed = completed;
	}

	
	
	public TodoEntity(int id, String title, String content, boolean completed) {
			super();
			this.id = id;
			this.title = title;
			this.content = content;
			this.completed = completed;
		}
	
		
		
	public TodoEntity(int id, String title, boolean completed) {
			super();
			this.id = id;
			this.title = title;
			this.completed = completed;
		}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	@Override
	  public String toString() {
	    return String.format("TODO[id=%d, Title='%s',Content='%s', completed='%b']", id, title, content,completed);
	  }
	
}
