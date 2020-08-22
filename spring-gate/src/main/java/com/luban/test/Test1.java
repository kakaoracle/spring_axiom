package com.luban.test;

import com.luban.app.AppConfig;
import com.luban.proxy.ProxyUtil;
import com.luban.proxy.Service;
import com.luban.proxy.ServiceLog;
import com.luban.proxy.ServicePower;
import com.luban.service.*;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		/*ac.getBean(SingletonDemo.class);
		ac.getBean(SingletonDemo.class);
		ac.getBean(PrototypeDemo.class);
		ac.getBean(PrototypeDemo.class);*/


		//UserDao userDao = (UserDao) ProxyUtil.newInstance(new UserDaoImpl());
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		genericBeanDefinition.setBeanClass(ZLService.class);
		genericBeanDefinition.setScope("singleton");
		genericBeanDefinition.setAutowireMode(2);

		ac.registerBeanDefinition("xxx",genericBeanDefinition);
		System.out.println(ac.getBean("xxx"));

		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
		// 这里如果有属性的话可以直接赋值
		//rootBeanDefinition.getPropertyValues().add("age",1);
		rootBeanDefinition.setAbstract(true);

		ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("aaa");
		childBeanDefinition.setBeanClass(ZLService.class);
		// 这里不能注入rootBeanDefinition了,因为已经设置为抽象了
		ac.registerBeanDefinition("aaa",rootBeanDefinition);
		ac.registerBeanDefinition("bbb",childBeanDefinition);
		System.out.println(ac.getBean("bbb"));
		ac.getBean("bbb").toString();


	}
}
