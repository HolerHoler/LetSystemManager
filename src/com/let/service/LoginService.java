package com.let.service;

import com.let.po.User;

public interface LoginService {
	// ʵ�ָ���username�����û���ҵ��
	public User findUserByUsername(String username);

}
