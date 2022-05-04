package com.juaena.service;

import com.juaena.aspect.JuaenaAop;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("c")
public class CService implements T {

	/**
	 * 测试 Aspectj 切面 切入方法
	 */
	@Override
	public void getDao(String s){
		System.out.println("CService** Dao-----");
	}

	@JuaenaAop
	@Override
	public void getDao1() {
		System.out.println("注解注入主方法！");
	}


}
