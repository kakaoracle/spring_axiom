package com.luban.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class LuBanService {
	public LuBanService(){
		System.out.println("init");
	}

	@PostConstruct
	public void xx(){
		System.out.println("xxxxx");
	}

}
