package com.let.dao;

import java.util.List;

import com.let.po.BrokerHouse;
import com.let.po.HouseInfo;

public interface BrokerHouseDao {
	public void addBrokerHouseToDB(BrokerHouse brokerHouse);

	public void updateBrokerHouseToDB(BrokerHouse brokerHouse);

	public void deleteBrokerHouseToDB(BrokerHouse brokerHouse);

	public List<BrokerHouse> findBrokerHouseByAll();

	public BrokerHouse findBrokerHouseByID(Long HouseHouseID);

	public List<BrokerHouse> findBrokerHouseByHouseID(Long HouseID);

	public List<BrokerHouse> findBrokerHouseByBrokerID(Long BrokerID);
	
	public void batchDel(String delIdArray);
}
