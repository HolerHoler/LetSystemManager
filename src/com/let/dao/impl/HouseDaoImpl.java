package com.let.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.HouseDao;
import com.let.po.HouseInfo;

@Repository("houseDao")
public class HouseDaoImpl extends HibernateDaoSupport implements HouseDao {

	// 注入工厂
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void addHouseToDB(HouseInfo house) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().save(house);
	}

	@Override
	public void updateHouseToDB(HouseInfo house) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().update(house);
	}

	@Override
	public void deleteHouseToDB(HouseInfo house) {
		// TODO 自动生成的方法存根
		getHibernateTemplate().delete(house);
	}

	@Override
	public List findHouseByAll() {
		// TODO 自动生成的方法存根
		List<HouseInfo> houseList = (List<HouseInfo>) getHibernateTemplate()
				.find("from HouseInfo");
		return houseList;
	}

	@Override
	public HouseInfo findHouseByID(Integer HouseID) {
		// TODO 自动生成的方法存根
		HouseInfo houseInfo = getHibernateTemplate().get(HouseInfo.class,
				HouseID);
		return houseInfo;
	}

}
