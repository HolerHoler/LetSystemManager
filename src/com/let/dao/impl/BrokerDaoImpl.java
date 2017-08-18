package com.let.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.BrokerDao;
import com.let.po.Broker;

@Repository("brokerDao")
public class BrokerDaoImpl extends HibernateDaoSupport implements BrokerDao {

	// 注入工厂
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void addBrokerToDB(Broker broker) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().save(broker);
	}

	@Override
	public void updateBrokerToDB(Broker broker) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().update(broker);
	}

	@Override
	public void deleteBrokerToDB(Broker broker) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().delete(broker);
	}

	@Override
	public List findBrokerByAll() {
		// TODO 自动生成的方法存根
		List<Broker> brokerList = (List<Broker>) getHibernateTemplate().find(
				"from Broker");
		return brokerList;
	}

	@Override
	public Broker findBrokerByID(Integer BrokerID) {
		// TODO 自动生成的方法存根
		Broker broker = getHibernateTemplate().get(Broker.class, BrokerID);
		return broker;
	}

}
