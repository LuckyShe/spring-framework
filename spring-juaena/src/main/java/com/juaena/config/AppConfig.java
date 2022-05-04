package com.juaena.config;


import com.juaena.service.PeopleService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configurable
@EnableAspectJAutoProxy   //开启Aspectj切面的支持 proxyTargetClass = true 表示使用CGlib来创建代理对象，系统默认false 使用jdk动态代理
@ComponentScan("com.juaena")
@EnableTransactionManagement  // 开启事务
public class AppConfig {
//	@Bean
//	public PeopleService getPeopleService1(){
//		return new PeopleService();
//	}

	/**
	 *	autowireCandidate  根据类型匹配后 会剔除这个bean
	 * @Primary  标注一个bean为主bean
	 * @return
	 */
//	@Bean(autowireCandidate = false)
//	public PeopleService getPeopleService2(){
//		return new PeopleService();
//	}

	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/restudy?characterEncoding=utf-8&amp;userSSl=false");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	//事务管理器
	@Bean
	public PlatformTransactionManager platformTransactionManager(){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

}
