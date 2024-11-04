package com.kodbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodbook.entities.User;
import com.kodbook.services.MailServices;
import com.kodbook.services.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	MailServices mailService;
	
	@PostMapping("/signUp")
	public String addUser(@ModelAttribute User user) {
		//user exist?
		String username = user.getUsername();
		String email = user.getEmail();
		boolean Status = service.userExists(username,email);
		if(Status == false) {
			service.addUser(user);
			mailService.sendMail(username,email);
			
		}
		
		return"index";
	}
	@PostMapping("/login")
	public String login(@RequestParam String username,
			@RequestParam String password) {
		boolean status =service.validateUser(username,password);
		if(status == true) {
			
			return"home";
		}
		else {
			return "index";
		}
	}
	
}
