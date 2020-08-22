package com.luban.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
public class ZLService implements ZL {
	public ZLService() {
		System.out.println("zlservice");
	}
}
