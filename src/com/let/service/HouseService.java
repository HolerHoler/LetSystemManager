package com.let.service;

import java.util.List;

import com.let.po.HouseInfo;

public interface HouseService {
	public void addHouse(HouseInfo house);

	public void updateHouse(HouseInfo house);

	public void deleteHouse(Integer HouseID);

	public List<HouseInfo> getHouseByAll();

	public HouseInfo getHouseByID(Integer HouseID);
}
