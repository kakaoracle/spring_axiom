package com.luban.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class BeanService {
	public BeanService() {
		System.out.println("beanService");
	}
}
