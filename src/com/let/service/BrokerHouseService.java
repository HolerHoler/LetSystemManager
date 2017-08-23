package com.let.service;

import java.util.List;

import com.let.po.BrokerHouse;

public interface BrokerHouseService {
	public void addBrokerHouse(BrokerHouse brokerHouse);

	public void updateBrokerHouse(BrokerHouse brokerHouse);

	public void deleteBrokerHouse(Integer BrokerHouseID);

	public List<BrokerHouse> getBrokerHouseByAll();

	public BrokerHouse getBrokerHouseByID(Integer BrokerHouseID);

	public List<BrokerHouse> getBrokerHouseByHouseID(Integer HouseID);

	public List<BrokerHouse> getBrokerHouseByBrokerID(Integer BrokerID);
	
	public void batchDelBrokerHouse(String delIdArray);
	
	
}
