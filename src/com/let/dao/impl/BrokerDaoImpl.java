package com.let.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.BrokerDao;
import com.let.po.Broker;

@Repository("brokerDao")
public class BrokerDaoImpl extends HibernateDaoSupport implements BrokerDao {

	// ע�빤��
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void addBrokerToDB(Broker broker) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().save(broker);
	}

	@Override
	public void updateBrokerToDB(Broker broker) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().update(broker);
	}

	@Override
	public void deleteBrokerToDB(Broker broker) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().delete(broker);
	}

	@Override
	public List findBrokerByAll() {
		// TODO �Զ����ɵķ������
		List<Broker> brokerList = (List<Broker>) getHibernateTemplate().find(
				"from Broker");
		return brokerList;
	}

	@Override
	public Broker findBrokerByID(Long BrokerID) {
		// TODO �Զ����ɵķ������
		Broker broker = getHibernateTemplate().get(Broker.class, BrokerID);
		return broker;
	}

	public void batchDel(String delIdArray) {
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
		Query q = session.createQuery("delete from Broker where " + hql);
		q.executeUpdate();
		session.close();
	}
}
