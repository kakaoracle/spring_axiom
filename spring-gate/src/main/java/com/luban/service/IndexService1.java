package com.luban.service;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class IndexService1 {
	// 该注解是spring容器销毁前执行的方法
	//@PreDestroy
	public void close(){
		System.out.println("indexService close");
	}
	public void shutdown(){
		System.out.println("indexService shutdown");
	}
}
