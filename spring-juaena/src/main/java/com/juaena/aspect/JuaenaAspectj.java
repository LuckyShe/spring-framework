package com.juaena.aspect;


import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JuaenaAspectj {

	@Around("pointCut()")
	public void around(ProceedingJoinPoint pjt) throws Throwable {
		//前置
		System.out.println("around执行前置");
		Object[] args = pjt.getArgs();
		System.out.println("参数"+args[0]);
		//业务
		Object proceed = pjt.proceed();
		//后置
		System.out.println("around执行后置");
	}

	/**
	 * @PointCut 表示一个切点，包含很多连接点
	 * execution 表示的连接点，可以多个，这里看表达式怎么写 还有很多写法
	 */
	@Pointcut("execution(* com.juaena.service.UserService.*(..))")
	public void pointCut(){

	}

	// 表示添加这个注解的会进入切面
	@Pointcut("@annotation(com.juaena.aspect.JuaenaAop))")
	public void pointCut1(){

	}

	/**
	 * 表示切面的通知，可以在执行方法的前后加逻辑
	 * @Before
	 * @After
	 */
	@After("pointCut()")
	public void advice(){
		System.out.println("After执行我的切面逻辑！！===");
	}
	/*
		也可以添加一个参数，来拿到切点方法的参数
	 */
	@Before("pointCut()")
	public void adviceAnno(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println("Before执行注解切面逻辑！！===");
	}




}
