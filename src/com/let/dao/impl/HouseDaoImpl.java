package com.let.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.let.dao.HouseDao;
import com.let.po.HouseInfo;

@Repository("houseDao")
public class HouseDaoImpl extends HibernateDaoSupport implements HouseDao {

	// ע�빤��
	@Resource(name = "sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void addHouseToDB(HouseInfo house) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().save(house);
	}

	@Override
	public void updateHouseToDB(HouseInfo house) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().update(house);
	}

	@Override
	public void deleteHouseToDB(HouseInfo house) {
		// TODO �Զ����ɵķ������
		getHibernateTemplate().delete(house);
	}

	@Override
	public List findHouseByAll() {
		// TODO �Զ����ɵķ������
		List<HouseInfo> houseList = (List<HouseInfo>) getHibernateTemplate()
				.find("from HouseInfo");
		return houseList;
	}

	@Override
	public HouseInfo findHouseByID(Long HouseID) {
		// TODO �Զ����ɵķ������
		HouseInfo houseInfo = getHibernateTemplate().get(HouseInfo.class,
				HouseID);
		return houseInfo;
	}

	@Override
	public void batchDel(String delIdArray) {
		// TODO �Զ����ɵķ������
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
		Query q = session.createQuery("delete from HouseInfo where " + hql);
		q.executeUpdate();
		session.close();
	}

}
