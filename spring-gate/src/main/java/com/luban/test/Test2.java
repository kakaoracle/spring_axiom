package com.luban.test;

import com.luban.annotation.KakaScan;
import com.luban.app.AppConfig;
import com.luban.beanDefinition.CustomScanner;
import com.luban.proxy.EchoServiceHandler;
import com.luban.proxy.KakaInvocationHandler;
import com.luban.service.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.Assert;

import java.lang.reflect.Proxy;

public class Test2 {
	public static void main(String[] args) {
		EchoServiceHandler echoServiceHandler = new EchoServiceHandler(new EchoServiceImpl());
		EchoService echoService = (EchoService) Proxy.newProxyInstance(EchoService.class.getClassLoader(), new Class[]{EchoService.class}, echoServiceHandler);
		echoService.echo("test");

		System.out.println("start");
		/*AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		//ac.register(AppConfig.class);
		ac.scan("com.luban");
		ac.refresh();

		CustomScanner customScanner = new CustomScanner(ac);
		//customScanner.addIncludeFilter(new AnnotationTypeFilter(KakaScan.class));
		int scan = customScanner.scan("com.luban");
		// 为1则成功扫描到
		System.out.println(scan);*/

		//UserDao o = (UserDao) Proxy.newProxyInstance(Test2.class.getClassLoader(), new Class[]{UserDao.class}, new KakaInvocationHandler(new UserDaoImpl()));
		//o.query();

		// 为了将自定义的方法作为destroy之前的方法,调用结束,看方法是否执行
		//ac.close();
		//GenericBeanDefinition indexService1 = (GenericBeanDefinition) ac.getBeanDefinition("indexService1");
		//indexService1.setDestroyMethodName(AbstractBeanDefinition.INFER_METHOD);
		//System.out.println(ac.getBeanDefinition("indexService"));
	}
}

















