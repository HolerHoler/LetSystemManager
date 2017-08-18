package com.let.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.LetDao;
import com.let.po.LetInfo;

@Repository("letDao")
public class LetDaoImpl extends HibernateDaoSupport implements LetDao {

	// ע�빤��
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void addLetToDB(LetInfo letInfo) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().save(letInfo);
	}

	@Override
	public void updateLetToDB(LetInfo letInfo) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().update(letInfo);
	}

	@Override
	public void deleteLetToDB(LetInfo letInfo) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().delete(letInfo);
	}

	@Override
	public List findLetByAll() {
		// TODO �Զ����ɵķ������
		List<LetInfo> letList = (List<LetInfo>) getHibernateTemplate().find(
				"from LetInfo");
		return letList;
	}

	@Override
	public LetInfo findBrokerByID(Integer LetID) {
		// TODO �Զ����ɵķ������
		LetInfo letInfo = getHibernateTemplate().get(LetInfo.class, LetID);
		return letInfo;
	}

}
