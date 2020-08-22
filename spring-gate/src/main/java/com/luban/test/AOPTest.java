package com.luban.test;

import com.luban.app.AppConfig;
import com.luban.beanDefinition.UserService1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 对应49,50两节课
 *
 * */
public class AOPTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService1 bean = ac.getBean(UserService1.class);
		System.out.println(bean);
	}
}
