package com.let.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.LetDao;
import com.let.po.LetInfo;

@Repository("letDao")
public class LetDaoImpl extends HibernateDaoSupport implements LetDao {

	// 注入工厂
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void addLetToDB(LetInfo letInfo) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().save(letInfo);
	}

	@Override
	public void updateLetToDB(LetInfo letInfo) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().update(letInfo);
	}

	@Override
	public void deleteLetToDB(LetInfo letInfo) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().delete(letInfo);
	}

	@Override
	public List findLetByAll() {
		// TODO 自动生成的方法存根
		List<LetInfo> letList = (List<LetInfo>) getHibernateTemplate().find(
				"from LetInfo");
		return letList;
	}

	@Override
	public LetInfo findBrokerByID(Long LetID) {
		// TODO 自动生成的方法存根
		LetInfo letInfo = getHibernateTemplate().get(LetInfo.class, LetID);
		return letInfo;
	}

	@Override
	public void batchDel(String delIdArray) {
		// TODO 自动生成的方法存根
		String hql = null;
		String[] delIds = delIdArray.split(",");
		for (int i = 0; i < delIds.length; i++) {
			System.out.println(delIds[i]);
			if (i == 0) {
				hql = "id=" + delIds[i];
			} else {
				hql = hql + " or id=" + delIds[i];
			}
		}
		Session session = this.getSessionFactory().openSession();
		Query q = session.createQuery("delete from LetInfo where " + hql);
		q.executeUpdate();
		session.close();
	}

}
