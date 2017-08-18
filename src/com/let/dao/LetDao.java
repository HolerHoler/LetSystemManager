package com.let.dao;

import java.util.List;

import com.let.po.LetInfo;

public interface LetDao {
	public void addLetToDB(LetInfo letInfo);

	public void updateLetToDB(LetInfo letInfo);

	public void deleteLetToDB(LetInfo letInfo);

	public List findLetByAll();

	public LetInfo findBrokerByID(Integer LetID);

}
