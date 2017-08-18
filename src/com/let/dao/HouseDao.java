package com.let.dao;

import java.util.List;

import com.let.po.HouseInfo;

public interface HouseDao {
	public void addHouseToDB(HouseInfo house);

	public void updateHouseToDB(HouseInfo house);

	public void deleteHouseToDB(HouseInfo house);

	public List findHouseByAll();

	public HouseInfo findHouseByID(Integer HouseID);

}
