package com.let.dao;

import java.util.List;

import com.let.po.BrokerHouse;
import com.let.po.HouseInfo;

public interface BrokerHouseDao {
	public void addBrokerHouseToDB(BrokerHouse brokerHouse);

	public void updateBrokerHouseToDB(BrokerHouse brokerHouse);

	public void deleteBrokerHouseToDB(BrokerHouse brokerHouse);

	public List<BrokerHouse> findBrokerHouseByAll();

	public BrokerHouse findBrokerHouseByID(Integer HouseHouseID);

	public List<BrokerHouse> findBrokerHouseByHouseID(Integer HouseID);

	public List<BrokerHouse> findBrokerHouseByBrokerID(Integer BrokerID);
}
