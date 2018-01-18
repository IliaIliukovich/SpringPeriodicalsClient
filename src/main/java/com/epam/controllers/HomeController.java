package com.epam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String goHome(){
		return "/home";
	}

	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String goLogin(){
		return "/login";
	}

	@RequestMapping("/error404")
	public String error404(){
		return "/error404";
	}

}
