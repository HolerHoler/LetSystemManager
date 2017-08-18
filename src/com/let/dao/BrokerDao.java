package com.let.dao;

import java.util.List;

import com.let.po.Broker;

public interface BrokerDao {
	public void addBrokerToDB(Broker broker);

	public void updateBrokerToDB(Broker broker);

	public void deleteBrokerToDB(Broker broker);

	public List findBrokerByAll();

	public Broker findBrokerByID(Integer BrokerID);
}
