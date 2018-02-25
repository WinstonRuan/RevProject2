package com.villains.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.villains.model.User;
import com.villains.pojo.Message;
import com.villains.service.UserService;
//MArk as a class
@Controller("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registerUser.app")
	public @ResponseBody ResponseEntity<Message> registerHero(@RequestBody User user){
		userService.registerUser(user);
		return new ResponseEntity<>(new Message("HERO REGISTERED SUCCESSFULLY"), HttpStatus.OK);
	}
	
	@GetMapping("/getAllUser.app")
	public @ResponseBody ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<>(userService.getAllUser() , HttpStatus.OK);
	}

}