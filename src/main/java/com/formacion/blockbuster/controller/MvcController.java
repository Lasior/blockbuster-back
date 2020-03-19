package com.formacion.blockbuster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
	
	@RequestMapping("/")
	public String slash(ModelMap model) {
		return "/home";
	}
	
	@RequestMapping("/home")
	public String home(ModelMap model) {
		return "/home";
	}
	
	@RequestMapping("/login")
	public String login(ModelMap model) {
		return "/login";
	}
	
	@RequestMapping("/hello")
	public String hello(ModelMap model) {
		return "/hello";
	}

}
