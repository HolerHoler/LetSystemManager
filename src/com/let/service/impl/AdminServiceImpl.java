package com.let.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.let.dao.AdminDao;
import com.let.po.User;
import com.let.service.AdminService;

@Transactional(readOnly = false)
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource(name = "adminDao")
	private AdminDao adminDao;

	@Override
	public void changePassword(User user) {
		// TODO 自动生成的方法存根
		adminDao.updatePassword(user);
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO 自动生成的方法存根
		return adminDao.getUserByUsername(username);
	}

}
