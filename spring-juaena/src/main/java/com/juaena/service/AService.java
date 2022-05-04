package com.juaena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AService {

	/**
	 * 三级缓存
	 * 	一级：单例池 singletonObjects map<beanName,object>
	 * 	二级：earlySingletonObjects map<beanName,object>
	 * 	三级：singletonFactories 	map<beanName,lambda(beanName,BeanDefinition,)>   = xxxMap  简称三级简称
	 *
	 *
	 * 当AService出现循环依赖的时候，就会提前进行AOP
	 * 0.creatingSet.add("aService")  正在创建中的bean
	 * 1.class---> 实例化得到AService原始对象 ----> xxxMap<beanName,lambda(beanName, BeanDefinition, AService)>  "这里存储只是为了解决循环依赖用"
	 * 2.给bService赋值   ----> 从单例池中找bService  ---> 找不到 ---> 创建BService的bean
	 *
	 * 		BService的生命周期
	 *			2.1、class---> 实例化得到BService原始对象
	 *			2.2、给aService赋值   ---->从单例池中找aService (一级缓存) --->找不到 ---> creatingSet ? --->AService出现循环依赖 --
	 *				--->earlySingletonObjects(二级缓存) ----> xxxMap (三级缓存) --->lambda执行(包含AService原始对象,因为代理对象需要关联原始对象)--
	 *				--> 提前AOP --->AService的代理对象  ---> earlySingletonObjects(对象放入二级缓存,同时三级缓存中的对象remove掉)
	 *			2.3、给其他属性赋值
	 *			2.4、其余事情
	 *			2.5、对象放到单例池中
	 *
	 * 3.给其他属性赋值
	 * 4.其余事情 AOP--->AService代理对象  (? 这里如何判断前面是否已经执行aop了呢？)
	 * 4.5 earlySingletonObjects.get("aService")  二级缓存拿出来放进单例池中
	 * 5.creatingSet.remove("aService")
	 * 6.对象放到单例池中
	 *
	 *
	 */

	@Autowired
	private BService bService;

//	@Autowired
//	private CService cService;
}
