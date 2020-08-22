package com.luban.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
* 循环引用测试
* */
@Component
public class UserService {

	@Autowired
	OrderService orderService;

	public UserService() {
		System.out.println("start userService");
	}
}
