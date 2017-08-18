package com.let.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.let.dao.LoginDao;
import com.let.po.User;
import com.let.service.LoginService;

@Transactional(readOnly = false)
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource(name = "loginDao")
	private LoginDao loginDao;

	// ʵ�ָ���username�����û���ҵ��
	@Override
	public User findUserByUsername(String username) {
		// TODO �Զ����ɵķ������
		return loginDao.getUserByUsername(username);
	}

}
