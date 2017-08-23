package com.let.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.BrokerHouseDao;
import com.let.po.BrokerHouse;

@Repository("brokerHouseDao")
public class BrokerHouseDaoImpl extends HibernateDaoSupport implements
		BrokerHouseDao {

	// 注入工厂
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void addBrokerHouseToDB(BrokerHouse brokerHouse) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().save(brokerHouse);
	}

	@Override
	public void updateBrokerHouseToDB(BrokerHouse brokerHouse) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().update(brokerHouse);
	}

	@Override
	public void deleteBrokerHouseToDB(BrokerHouse brokerHouse) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().delete(brokerHouse);
	}

	@Override
	public List findBrokerHouseByAll() {
		// TODO 自动生成的方法存根
		List<BrokerHouse> brokerHouseList = (List<BrokerHouse>) getHibernateTemplate()
				.find("from BrokerHouse");
		return brokerHouseList;

	}

	@Override
	public BrokerHouse findBrokerHouseByID(Integer BrokerHouseID) {
		// TODO 自动生成的方法存根
		BrokerHouse bokerHouse = getHibernateTemplate().get(BrokerHouse.class,
				BrokerHouseID);
		return bokerHouse;
	}

	@Override
	public List<BrokerHouse> findBrokerHouseByHouseID(Integer HouseID) {
		// TODO 自动生成的方法存根
		String hql = "from BrokerHouse where house.id='" + HouseID + "'";
		List<BrokerHouse> brokerHouseListByHouseID = (List<BrokerHouse>) getHibernateTemplate()
				.find(hql);
		return brokerHouseListByHouseID;
	}

	@Override
	public List<BrokerHouse> findBrokerHouseByBrokerID(Integer BrokerID) {
		// TODO 自动生成的方法存根
		String hql = "from BrokerHouse where broker.id='" + BrokerID + "'";
		List<BrokerHouse> brokerHouseListByBrokerID = (List<BrokerHouse>) getHibernateTemplate()
				.find(hql);
		return brokerHouseListByBrokerID;
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
		Query q = session.createQuery("delete from BrokerHouse where " + hql);
		q.executeUpdate();
		session.close();
	}

}
