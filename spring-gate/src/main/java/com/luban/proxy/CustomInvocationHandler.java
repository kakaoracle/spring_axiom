package com.luban.proxy;

import java.lang.reflect.Method;

public interface CustomInvocationHandler {
	Object invoke(Method method) throws Exception;
}
