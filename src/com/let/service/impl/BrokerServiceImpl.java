package com.let.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.let.dao.BrokerDao;
import com.let.dao.LoginDao;
import com.let.po.Broker;
import com.let.service.BrokerService;

@Transactional(readOnly = false)
@Service("brokerService")
public class BrokerServiceImpl implements BrokerService {
	@Resource(name = "brokerDao")
	private BrokerDao brokerDao;

	@Override
	public void addBroker(Broker broker) {
		// TODO �Զ����ɵķ������
		brokerDao.addBrokerToDB(broker);
	}

	@Override
	public void updateBroker(Broker broker) {
		// TODO �Զ����ɵķ������
		brokerDao.updateBrokerToDB(broker);
	}

	@Override
	public void deleteBroker(Long BrokerID) {
		// TODO �Զ����ɵķ������
		Broker broker = brokerDao.findBrokerByID(BrokerID);
		brokerDao.deleteBrokerToDB(broker);
	}

	@Override
	public List<Broker> getBrokerByAll() {
		// TODO �Զ����ɵķ������
		List brokerList = brokerDao.findBrokerByAll();
		return brokerList;
	}

	@Override
	public Broker getBrokerByID(Long BrokerID) {
		// TODO �Զ����ɵķ������
		Broker broker = brokerDao.findBrokerByID(BrokerID);
		return broker;
	}

	@Override
	public void batchDelBroker(String delIdArray) {
		// TODO �Զ����ɵķ������
		brokerDao.batchDel(delIdArray);
	}

}
