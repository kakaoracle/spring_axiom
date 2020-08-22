package com.luban.service;

public class IndexServiceLProxy extends IndexService {
	public void query(){
		System.out.println("start log");
		super.query();
	}
}
