package com.juaena.test;

import com.juaena.config.AppConfig;
import com.juaena.service.PeopleService;
import com.juaena.service.UserService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.publishEvent(new ApplicationEvent("手动发布一个事件！") {
			@Override
			public Object getSource() {
				return super.getSource();
			}
		});
//		UserService bean = context.getBean(UserService.class);
//		PeopleService bean = context.getBean(PeopleService.class);
//		bean.peopleMethod();
//		bean.userMethod();

	}
}
