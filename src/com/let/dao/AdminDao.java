package com.let.dao;

import com.let.po.User;

public interface AdminDao {
	public User getUserByUsername(String username);

	public void updatePassword(User user);
}
