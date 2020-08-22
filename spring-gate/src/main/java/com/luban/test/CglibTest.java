package com.luban.test;

import com.luban.app.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 第49节cglib
 *
 *
 * */
public class CglibTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	}

}
