package com.luban.proxy;


import java.lang.reflect.Method;

public class KakaInvocationHandler implements CustomInvocationHandler{

	Object target;

	public KakaInvocationHandler(Object target){
		this.target=target;
	}

	@Override
	public Object invoke(Method method) throws Exception{
		System.out.println("代理类的实现逻辑");
		// method.invoke可以执行方法,类.方法调用=反射方法.class
		return  method.invoke(target);
	}
}
