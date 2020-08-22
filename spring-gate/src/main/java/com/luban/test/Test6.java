package com.luban.test;

import com.luban.app.AppConfig;
import com.luban.beanDefinition.KakaRegistryProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.addBeanFactoryPostProcessor(new KakaRegistryProcessor());
		ac.refresh();
	}
}