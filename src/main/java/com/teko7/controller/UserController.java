package com.teko7.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teko7.entities.TodoEntity;
import com.teko7.entities.UserEntity;
import com.teko7.service.Service;
import com.teko7.validator.UserValidator;

@RequestMapping("/users")
@Controller
public class UserController {

	
	private Service getService() {return new Service();}
	private UserValidator getUserValidator() {return new UserValidator();}
	
	private Service service = getService();
	private UserValidator userValidator = getUserValidator();
	
	
	@GetMapping("/users")
	public String getAllUsers(Model theModel) {
		List<UserEntity> users = (List<UserEntity>)service.getAll("user");
		theModel.addAttribute("users",users);
		return "users";
	}
	
	@GetMapping("/registration")
	public String registerUser(Model theModel) {
		theModel.addAttribute("user",new UserEntity());
		return "registration";
	}
	
	@PostMapping("registration")
	public String registerUser(@ModelAttribute("user") UserEntity user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		System.out.println("bindingResult : " + bindingResult);
		if (bindingResult.hasErrors()) {
            return "registration";
        }
		service.save(user);
		
		return "redirect:/users/users";
	}
	
	@GetMapping("/login")
	public String loginUser(Model theModel) {
		theModel.addAttribute("user",new UserEntity());
		return "login";
	}
	
	@PostMapping("login")
	public String loginUser(@ModelAttribute("user") UserEntity user) {
		service.save(user);
		System.out.println("USER : " + user);
		return "redirect:/users/users";
	}
	
	@RequestMapping(value="adduser", method = RequestMethod.GET)
	public String showFormForAddUser(Model theModel) {
		
		UserEntity user = new UserEntity();
		theModel.addAttribute("user",user);
		return "addUserForm";
	}
	
	@RequestMapping(value="adduser", method = RequestMethod.POST)
	public String addTodo(@ModelAttribute("user") UserEntity user) {
		service.save(user);
		return "redirect:/users/users";
	}
	
	@RequestMapping(value="deleteuser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int theId) {
		service.delete("user",theId);
		return "redirect:/users/users";
	}
	
	@RequestMapping(value="updateuser", method = RequestMethod.GET)
	public String updateUser(@RequestParam("id") int theId,Model theModel) {
		UserEntity user = ((UserEntity)service.getById("user",theId));
		theModel.addAttribute("user",user);
		return "addUserForm";
	}
	
	
	
	
}
