package com.luban.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理内容
 * */
public class EchoServiceHandler implements InvocationHandler {
	private Object object;

	public EchoServiceHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before invoke");
		return method.invoke(object,args);
	}
}
