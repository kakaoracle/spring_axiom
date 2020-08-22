package com.luban.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotVeryUsefulAspect {
	@Pointcut("execution(public * com.luban.beanDefinition.*.*(..))")
	private void pointCutexecutionAny(){}

	@Before("pointCutexecutionAny()")
	public void doAccessCheck(){
		System.out.println("tx-------------");
	}

}
