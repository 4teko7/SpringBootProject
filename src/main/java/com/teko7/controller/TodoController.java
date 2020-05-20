package com.teko7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teko7.entities.TodoEntity;
import com.teko7.entities.UserEntity;
import com.teko7.service.DatabaseService;


//@RestController
@Controller
//@Component
@RequestMapping("/todos")
public class TodoController {

	
	private DatabaseService getService() {return new DatabaseService();}
	
	private DatabaseService service = getService();
	

	@GetMapping("/todos")
	public String getTodos(Model theModel) {
		List<TodoEntity> todos = (List<TodoEntity>)service.getAll("todo");
		theModel.addAttribute("todos",todos);
		return "todos";
	}
	
	@RequestMapping(value="addtodo", method = RequestMethod.GET)
	public String showFormForAddTodo(Model theModel) {
		
		TodoEntity todo = new TodoEntity();
		theModel.addAttribute("todo",todo);
		return "addTodoForm";
	}
	
	@RequestMapping(value="addtodo", method = RequestMethod.POST)
	public String addTodo(@ModelAttribute("TodoEntity") TodoEntity todo) {
		service.save(todo);
		return "redirect:/todos/todos/";
	}
	
	@RequestMapping(value="deletetodo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam("id") int theId) {
		service.delete("todo",theId);
		return "redirect:/todos/todos";
	}
	
	@RequestMapping(value="updatetodo", method = RequestMethod.GET)
	public String updateTodo(@RequestParam("id") int theId,Model theModel) {
		TodoEntity todo = ((TodoEntity)service.getById("todo",theId));
		theModel.addAttribute("todo",todo);
		System.out.println("OUR TODO : " + todo);
		return "addTodoForm";
	}
	
	
}

