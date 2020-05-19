package com.teko7.rest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.teko7.entities.TodoEntity;

@RestController
@RequestMapping("/")
public class DemoRestController {

	ObjectMapper mapper = new ObjectMapper();
	
//	@GetMapping({"/index"})
//	public ModelAndView getAllProjectsView( @RequestParam("page") Optional<Integer> page) {
//
//		ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//		return modelAndView;
//	}
////	
//
//	@GetMapping("/todos")
//	public TodoEntity getTodos() {
//		TodoEntity todos = null;
//		try {
//			todos = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos/1"),TodoEntity.class) ;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return todos;
//	}
}
