package com.juaena.config;

import com.juaena.service.PeopleService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	/**
	 * 所有的Bean定义信息已经加载到容器中，但是Bean实例还没有被初始化.
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition userService = (GenericBeanDefinition) beanFactory.getBeanDefinition("userService");
		System.out.println("------进入beanfactory------");
//		userService.setBeanClass(PeopleService.class);
//		for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
//			if ("aService".equals(beanDefinitionName)){
//				System.out.println("拿到了bean定义了");
//			}
//		}
//		userService.setBeanClassName("peopleService");
	}
}
