package com.let.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.RenterDao;
import com.let.po.HouseInfo;
import com.let.po.Renter;

@Repository("renterDao")
public class RenterDaoImpl extends HibernateDaoSupport implements RenterDao {
	// 注入工厂
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void addRenterToDB(Renter renter) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().save(renter);
	}

	@Override
	public void updateRenterToDB(Renter renter) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().update(renter);
	}

	@Override
	public void deleteRenterToDB(Renter renter) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().delete(renter);
	}

	@Override
	public List findRenterByAll() {
		// TODO 自动生成的方法存根
		List<Renter> renterList = (List<Renter>) getHibernateTemplate().find(
				"from Renter");
		return renterList;
	}

	@Override
	public Renter findRenterByID(Integer RenterID) {
		// TODO 自动生成的方法存根
		Renter renter = getHibernateTemplate().get(Renter.class, RenterID);
		return renter;
	}

}
