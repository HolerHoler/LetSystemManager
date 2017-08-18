package com.let.service;

import com.let.po.User;

public interface LoginService {
	// 实现根据username查找用户的业务
	public User findUserByUsername(String username);

}
