package com.juaena.config;

import com.juaena.service.CService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionPostProcessor implements BeanDefinitionRegistryPostProcessor, InitializingBean {

	/**
	 * 所有的bean定义信息'将要'被加载到容器中，Bean实例还没有被初始化。
	 * @param registry the bean definition registry used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinationRegisterPostProcessor的postProcessBeanDefinitionRegistry方法");
		System.out.println("bean定义的数据量:"+registry.getBeanDefinitionCount());
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(CService.class);
		registry.registerBeanDefinition("CService",rootBeanDefinition);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinationRegisterPostProcessor的postProcessBeanFactory方法");
		System.out.println(beanFactory.getBeanDefinitionCount());
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
