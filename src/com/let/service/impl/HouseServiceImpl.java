package com.let.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.let.dao.BrokerDao;
import com.let.dao.HouseDao;
import com.let.po.HouseInfo;
import com.let.service.HouseService;

@Transactional(readOnly = false)
@Service("houseService")
public class HouseServiceImpl implements HouseService {
	@Resource(name = "houseDao")
	private HouseDao houseDao;

	@Override
	public void addHouse(HouseInfo house) {
		// TODO �Զ����ɵķ������
		houseDao.addHouseToDB(house);
	}

	@Override
	public void updateHouse(HouseInfo house) {
		// TODO �Զ����ɵķ������
		houseDao.updateHouseToDB(house);
	}

	@Override
	public void deleteHouse(Integer HouseID) {
		// TODO �Զ����ɵķ������
		HouseInfo house = houseDao.findHouseByID(HouseID);
		houseDao.deleteHouseToDB(house);
	}

	@Override
	public List<HouseInfo> getHouseByAll() {
		// TODO �Զ����ɵķ������
		List houseList = houseDao.findHouseByAll();
		return houseList;
	}

	@Override
	public HouseInfo getHouseByID(Integer HouseID) {
		// TODO �Զ����ɵķ������
		HouseInfo house = houseDao.findHouseByID(HouseID);
		return house;
	}

	@Override
	public void batchDelHouse(String delIdArray) {
		// TODO �Զ����ɵķ������
		houseDao.batchDel(delIdArray);
	}

}
