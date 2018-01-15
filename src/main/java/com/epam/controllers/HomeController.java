package com.epam.controllers;

import com.epam.entities.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class HomeController {

	@RequestMapping("/")
	public String goHome(){
		return "/home";
	}

	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String goLogin(){
		return "/login";
	}

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String goRegister(){
		return "/register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute User user, Errors errors, SessionStatus status){
		if (!errors.hasErrors()) {
			Authentication auth = new UsernamePasswordAuthenticationToken(user,
					user.getPassword(), user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
			status.setComplete();
			return "redirect:/";
		} else {
			return "/register";
		}
	}

	@RequestMapping("/error404")
	public String error404(){
		return "/error404";
	}

	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}

}
