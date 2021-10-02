package com.juaena.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

//	@Autowired
//	private PeopleService peopleService;

	UserService(){
		System.out.println("userService constructor execute !@!");
	}

	public void userMethod(){
		System.out.println("userMethod execute !!@#-");
	}

}
