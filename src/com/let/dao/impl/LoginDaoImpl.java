package com.let.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.LoginDao;
import com.let.po.User;

@Repository("loginDao")
public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao {
	// 注入工厂
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO 自动生成的方法存根
		String hql = "from User as user where user.username='" + username + "'";
		Session session = this.getSessionFactory().openSession();
		User user = (User) session.createQuery(hql).setMaxResults(1)
				.uniqueResult();
		session.close();
		return user;
	}

}
