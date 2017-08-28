package com.let.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.let.dao.LetDao;
import com.let.dao.LoginDao;
import com.let.po.LetInfo;
import com.let.service.LetInfoService;

@Transactional(readOnly = false)
@Service("letInfoService")
public class LetInfoServeiceImpl implements LetInfoService {
	@Resource(name = "letDao")
	private LetDao letDao;

	@Override
	public void addLet(LetInfo letInfo) {
		// TODO 自动生成的方法存根
		letDao.addLetToDB(letInfo);
	}

	@Override
	public void updateLet(LetInfo letInfo) {
		// TODO 自动生成的方法存根
		letDao.updateLetToDB(letInfo);
	}

	@Override
	public void deleteLet(Long LetID) {
		// TODO 自动生成的方法存根
		LetInfo letInfo = letDao.findBrokerByID(LetID);
		letDao.deleteLetToDB(letInfo);
	}

	@Override
	public List<LetInfo> getLetByAll() {
		// TODO 自动生成的方法存根
		List letList = letDao.findLetByAll();
		return letList;
	}

	@Override
	public LetInfo getLetByID(Long LetID) {
		// TODO 自动生成的方法存根
		LetInfo letInfo = letDao.findBrokerByID(LetID);
		return letInfo;
	}

	@Override
	public void batchDelLet(String delIdArray) {
		// TODO 自动生成的方法存根
		letDao.batchDel(delIdArray);
	}

}
