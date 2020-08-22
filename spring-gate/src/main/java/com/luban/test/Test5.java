package com.luban.test;

import com.luban.app.AppConfig;
import com.luban.beanDefinition.CustomScanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test5 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		ac.scan("com.luban.app.AppConfig");
		ac.refresh();
		CustomScanner customScanner = new CustomScanner(ac);
		customScanner.addIncludeFilter(null);
		int scan = customScanner.scan("com.luban");
		System.out.println("绗﹀悎kakascan娉ㄨВ鐨勭被鏁伴噺="+scan);
	}
}
