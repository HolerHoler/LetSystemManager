package com.let.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.let.dao.BrokerHouseDao;
import com.let.po.BrokerHouse;
import com.let.service.BrokerHouseService;

@Transactional(readOnly = false)
@Service("brokerHouseService")
public class BrokerHouseServiceImpl implements BrokerHouseService {
	@Resource(name = "brokerHouseDao")
	private BrokerHouseDao brokerHouseDao;

	@Override
	public void addBrokerHouse(BrokerHouse brokerHouse) {
		// TODO �Զ����ɵķ������
		brokerHouseDao.addBrokerHouseToDB(brokerHouse);
	}

	@Override
	public void updateBrokerHouse(BrokerHouse brokerHouse) {
		// TODO �Զ����ɵķ������
		brokerHouseDao.updateBrokerHouseToDB(brokerHouse);
	}

	@Override
	public void deleteBrokerHouse(Integer BrokerHouseID) {
		// TODO �Զ����ɵķ������
		BrokerHouse brokerHouse = brokerHouseDao
				.findBrokerHouseByID(BrokerHouseID);
		brokerHouseDao.deleteBrokerHouseToDB(brokerHouse);
	}

	@Override
	public List<BrokerHouse> getBrokerHouseByAll() {
		// TODO �Զ����ɵķ������
		List brokerHouseList = brokerHouseDao.findBrokerHouseByAll();
		return brokerHouseList;
	}

	@Override
	public BrokerHouse getBrokerHouseByID(Integer BrokerHouseID) {
		// TODO �Զ����ɵķ������
		BrokerHouse brokerHouse = brokerHouseDao
				.findBrokerHouseByID(BrokerHouseID);
		return brokerHouse;
	}

	@Override
	public List<BrokerHouse> getBrokerHouseByHouseID(Integer HouseID) {
		// TODO �Զ����ɵķ������
		List brokerHouseListByHouseID = brokerHouseDao
				.findBrokerHouseByHouseID(HouseID);
		return brokerHouseListByHouseID;
	}

	@Override
	public List<BrokerHouse> getBrokerHouseByBrokerID(Integer BrokerID) {
		// TODO �Զ����ɵķ������
		List brokerHouseListByBrokerID = brokerHouseDao
				.findBrokerHouseByBrokerID(BrokerID);
		return brokerHouseListByBrokerID;
	}
}
