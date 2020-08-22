package com.luban.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
* 循环引用用
* */
@Component
public class OrderService {

	@Autowired
	UserService userService;

	public OrderService() {
		System.out.println("start order");
	}
}
