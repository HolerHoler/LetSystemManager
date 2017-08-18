package com.let.dao;

import java.util.List;

import com.let.po.User;



public interface LoginDao {
	// 根据username找到对应的user
	public User getUserByUsername(String username);

}
