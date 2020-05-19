//package com.teko7.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.teko7.entities.TodoEntity;
//import com.teko7.todo.repository.TodoRepository;
//
//@Service
//public class TodoServiceImp implements TodoService {
//
//	@Autowired
//	private TodoRepository repository;
//	
//
//	@Override
//	public List<TodoEntity> findByCompleted(boolean completed) {
//		return ((List<TodoEntity>) repository.findByCompleted(completed)) ;
//	}
//	
//	public void save(TodoEntity entity) {
//		repository.save(entity);
//	}
//
//
//	@Override
//	public List<TodoEntity> findAll() {
//		return (List<TodoEntity>) repository.findAll();
//	}
//
//	@Override
//	public TodoEntity findById(int id) {
//		// TODO Auto-generated method stub
//		return  repository.findById(id);
//	}
//
//}
