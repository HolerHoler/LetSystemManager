package com.let.dao;

import java.util.List;

import com.let.po.User;



public interface LoginDao {
	// ����username�ҵ���Ӧ��user
	public User getUserByUsername(String username);

}
