package com.luban.test;

import com.luban.service.BeanService;

import java.lang.reflect.Method;

public class Test4 {
	public static void main(String[] args) throws Exception{
		BeanService beanService = new BeanService();
		Method method = beanService.getClass().getDeclaredMethod("out");
		method.invoke(beanService);
	}
}
