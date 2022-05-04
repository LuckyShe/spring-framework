package com.juaena.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Spring是如何发布事件的? ApplicationListener
 */
//@Component
public class JuaenaApplicationListener implements ApplicationListener<ApplicationEvent> {
	//接受到消息，回调该方法
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("JuaenaApplicationListener 接收到一个事件"+ event);
	}
}
