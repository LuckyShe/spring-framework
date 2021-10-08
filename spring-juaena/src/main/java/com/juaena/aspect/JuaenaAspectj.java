package com.juaena.aspect;


import java.lang.reflect.Method;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class JuaenaAspectj implements MethodBeforeAdvice {


	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("=="+method);
	}
}
