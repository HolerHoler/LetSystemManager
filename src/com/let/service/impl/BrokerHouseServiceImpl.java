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
		// TODO 自动生成的方法存根
		brokerHouseDao.addBrokerHouseToDB(brokerHouse);
	}

	@Override
	public void updateBrokerHouse(BrokerHouse brokerHouse) {
		// TODO 自动生成的方法存根
		brokerHouseDao.updateBrokerHouseToDB(brokerHouse);
	}

	@Override
	public void deleteBrokerHouse(Integer BrokerHouseID) {
		// TODO 自动生成的方法存根
		BrokerHouse brokerHouse = brokerHouseDao
				.findBrokerHouseByID(BrokerHouseID);
		brokerHouseDao.deleteBrokerHouseToDB(brokerHouse);
	}

	@Override
	public List<BrokerHouse> getBrokerHouseByAll() {
		// TODO 自动生成的方法存根
		List brokerHouseList = brokerHouseDao.findBrokerHouseByAll();
		return brokerHouseList;
	}

	@Override
	public BrokerHouse getBrokerHouseByID(Integer BrokerHouseID) {
		// TODO 自动生成的方法存根
		BrokerHouse brokerHouse = brokerHouseDao
				.findBrokerHouseByID(BrokerHouseID);
		return brokerHouse;
	}

	@Override
	public List<BrokerHouse> getBrokerHouseByHouseID(Integer HouseID) {
		// TODO 自动生成的方法存根
		List brokerHouseListByHouseID = brokerHouseDao
				.findBrokerHouseByHouseID(HouseID);
		return brokerHouseListByHouseID;
	}

	@Override
	public List<BrokerHouse> getBrokerHouseByBrokerID(Integer BrokerID) {
		// TODO 自动生成的方法存根
		List brokerHouseListByBrokerID = brokerHouseDao
				.findBrokerHouseByBrokerID(BrokerID);
		return brokerHouseListByBrokerID;
	}
}
