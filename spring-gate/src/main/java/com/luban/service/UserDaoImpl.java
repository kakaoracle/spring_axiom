package com.luban.service;

public class UserDaoImpl implements UserDao {
	@Override
	public String proxy() throws Exception {
		System.out.println("起初实现类的逻辑");
		return "proxy";
	}
}
