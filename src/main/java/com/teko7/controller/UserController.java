package com.teko7.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teko7.database.Database;
import com.teko7.entities.TodoEntity;
import com.teko7.entities.UserEntity;

@RequestMapping("/users")
@Controller
public class UserController {

	
	private Database getDatabase() {return new Database();}
	
	
	
	@GetMapping("/users")
	public String getAllUsers(Model theModel) {
		List<UserEntity> users = (List<UserEntity>)getDatabase().getAll("user");
		theModel.addAttribute("users",users);
		return "users";
	}
	
	@RequestMapping(value="adduser", method = RequestMethod.GET)
	public String showFormForAddUser(Model theModel) {
		
		UserEntity user = new UserEntity();
		theModel.addAttribute("user",user);
		return "addUserForm";
	}
	
	@RequestMapping(value="adduser", method = RequestMethod.POST)
	public String addTodo(@ModelAttribute("user") UserEntity user) {
		getDatabase().save(user);
		return "redirect:/users/users";
	}
	
	@RequestMapping(value="deleteuser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int theId) {
		getDatabase().delete("user",theId);
		return "redirect:/users/users";
	}
	
	@RequestMapping(value="updateuser", method = RequestMethod.GET)
	public String updateUser(@RequestParam("id") int theId,Model theModel) {
		UserEntity user = ((UserEntity)getDatabase().getById("user",theId));
		theModel.addAttribute("user",user);
		return "addUserForm";
	}
	
	
	
	
}
