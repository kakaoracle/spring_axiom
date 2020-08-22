package com.luban.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonDemo {
	public SingletonDemo() {
		System.out.println("singleton");
	}
}
