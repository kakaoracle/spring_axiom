package com.luban.test;

import com.luban.app.AppConfig;
import com.luban.service.OrderService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
* 测试循环引用
* */
public class Test9 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		//System.out.println(ac.getBean(OrderService.class));
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ac.getBeanFactory();
		beanFactory.setAllowCircularReferences(false);
		System.out.println(ac.getBean(OrderService.class));
	}
}
