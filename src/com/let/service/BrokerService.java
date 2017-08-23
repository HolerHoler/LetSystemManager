package com.let.service;

import java.util.List;

import com.let.po.Broker;

public interface BrokerService {
	public void addBroker(Broker broker);

	public void updateBroker(Broker broker);

	public void deleteBroker(Integer BrokerID);

	public List<Broker> getBrokerByAll();

	public Broker getBrokerByID(Integer BrokerID);

	public void batchDelBroker(String delIdArray);

}
