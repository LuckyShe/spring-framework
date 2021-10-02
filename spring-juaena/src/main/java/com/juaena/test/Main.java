package com.juaena.test;

import com.juaena.config.AppConfig;
import com.juaena.service.PeopleService;
import com.juaena.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//		UserService bean = context.getBean(UserService.class);
		PeopleService bean = context.getBean(PeopleService.class);
		bean.peopleMethod();
//		bean.userMethod();

	}
}
