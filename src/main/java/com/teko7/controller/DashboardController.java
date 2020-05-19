package com.teko7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dynamic")
public class DashboardController {

	
	@RequestMapping("/dashboard")
	public String getDashboard() {
		return "indexjsp";
	}
}
