package com.let.service;

import com.let.po.User;

public interface AdminService {

	public void changePassword(User user);

	public User findUserByUsername(String username);

}
