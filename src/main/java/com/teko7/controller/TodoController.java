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

import com.teko7.database.Database;
import com.teko7.entities.TodoEntity;
//import com.teko7.service.TodoService;
//import com.teko7.service.TodoServiceImp;
//import com.teko7.todo.repository.TodoRepository;
import com.teko7.entities.UserEntity;


//@RestController
@Controller
//@Component
@RequestMapping("/todos")
public class TodoController {

	
	private Database getDatabase() {return new Database();}
	
	
	
	
//	@Autowired
//	private TodoService todoService;
	
//	private TodoRepository todoRepository;
//	
//	
//
//    @RequestMapping("/save")
//    public String process(){
//    	todoRepository.save(new TodoEntity(1,"Jack", false));
//    	todoRepository.save(new TodoEntity(2,"Adam", false));
//    	todoRepository.save(new TodoEntity(3,"Kim", false));
//    	todoRepository.save(new TodoEntity(4,"David", false));
//    	todoRepository.save(new TodoEntity(5,"Peter", false));
//        return "Done";
//    }
//      
//      
//    @RequestMapping("/findall")
//    public String findAll(){
//        String result = "<html>";
//          
//        for(TodoEntity cust : todoRepository.findAll()){
//            result += "<div>" + cust.toString() + "</div>";
//        }
//          
//        return result + "</html>";
//    }
//      
//    @RequestMapping("/findbyid")
//    public String findById(@RequestParam("id") int id){
//        String result = "";
//        result = todoRepository.findById(id).toString();
//        return result;
//    }
      
//    @RequestMapping("/findByCompleted")
//    public String fetchDataByLastName(@RequestParam("completed") boolean completed){
//        String result = "<html>";
//          
//        for(TodoEntity cust: todoRepository.findByCompleted(completed)){
//            result += "<div>" + cust.toString() + "</div>"; 
//        }
//          
//        return result + "</html>";
//    }
	
	@GetMapping("/todos")
	public String getTodos(Model theModel) {
		List<TodoEntity> todos = (List<TodoEntity>)getDatabase().getAll("todo");
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
		getDatabase().save(todo);
		return "redirect:/todos/todos/";
	}
	
	@RequestMapping(value="deletetodo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam("id") int theId) {
		getDatabase().delete("todo",theId);
		return "redirect:/todos/todos";
	}
	
	@RequestMapping(value="updatetodo", method = RequestMethod.GET)
	public String updateTodo(@RequestParam("id") int theId,Model theModel) {
		TodoEntity todo = ((TodoEntity)getDatabase().getById("todo",theId));
		theModel.addAttribute("todo",todo);
		System.out.println("OUR TODO : " + todo);
		return "addTodoForm";
	}
	
	
}

