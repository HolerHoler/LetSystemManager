package com.let.service;

import java.util.List;

import com.let.po.BrokerHouse;

public interface BrokerHouseService {
	public void addBrokerHouse(BrokerHouse brokerHouse);

	public void updateBrokerHouse(BrokerHouse brokerHouse);

	public void deleteBrokerHouse(Long BrokerHouseID);

	public List<BrokerHouse> getBrokerHouseByAll();

	public BrokerHouse getBrokerHouseByID(Long BrokerHouseID);

	public List<BrokerHouse> getBrokerHouseByHouseID(Long HouseID);

	public List<BrokerHouse> getBrokerHouseByBrokerID(Long BrokerID);
	
	public void batchDelBrokerHouse(String delIdArray);
	
	
}
