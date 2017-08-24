package com.let.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.AdminDao;
import com.let.po.User;

@Repository("adminDao")
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	// ע�빤��
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO �Զ����ɵķ������
		String hql = "from User as user where user.username='" + username + "'";
		Session session = this.getSessionFactory().openSession();
		User user = (User) session.createQuery(hql).setMaxResults(1)
				.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public void updatePassword(User user) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().update(user);
	}

}
