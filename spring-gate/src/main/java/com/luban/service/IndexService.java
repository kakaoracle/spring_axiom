package com.luban.service;

import com.luban.annotation.kaka;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

//@Component
public class IndexService {
	@kaka
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void query(){
		System.out.println("logic");
	}
}











