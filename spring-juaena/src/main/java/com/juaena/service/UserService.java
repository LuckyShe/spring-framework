package com.juaena.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {

//	@Autowired
//	private PeopleService peopleService;   //bytype  byname

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Spring 事务是通过拿到bean的代理对象，通过在代理逻辑中添加方法实现事务提交和回滚
	 * 		1.建立数据库连接
	 * 		2.conn.setAutocommit(false)
	 * 		3.target.method()    目标类真实方法
	 * 		4.commit() 		 提交
	 *
	 * 	建立事务的对象是这个 代理类的对象，并不是目标类的对象所以，事务传播机制在代理对象上生效
	 */

	//添加事务
	@Transactional
	public void userMethod(){

		jdbcTemplate.execute("insert into test values(1,'sam')");
		throw new NullPointerException();
	}

}
