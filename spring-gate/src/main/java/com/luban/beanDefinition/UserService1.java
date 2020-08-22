package com.luban.beanDefinition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 专门用来测试aop
 *
 * */
@Component
public class UserService1 {


	public UserService1() {
		System.out.println("start user1");
	}

	@Override
	public String toString() {
		return "UserService1{}";
	}
}
