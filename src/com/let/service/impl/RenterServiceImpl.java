package com.let.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.let.dao.RenterDao;
import com.let.po.Renter;
import com.let.service.RenterService;

@Transactional(readOnly = false)
@Service("renterService")
public class RenterServiceImpl implements RenterService {
	@Resource(name = "renterDao")
	private RenterDao renterDao;

	@Override
	public void addRenter(Renter renter) {
		// TODO 自动生成的方法存根
		renterDao.addRenterToDB(renter);
	}

	@Override
	public void updateRenter(Renter renter) {
		// TODO 自动生成的方法存根
		renterDao.updateRenterToDB(renter);
	}

	@Override
	public void deleteRenter(Integer RenterID) {
		// TODO 自动生成的方法存根
		Renter renter = renterDao.findRenterByID(RenterID);
		renterDao.deleteRenterToDB(renter);
	}

	@Override
	public List<Renter> getRenterByAll() {
		// TODO 自动生成的方法存根
		List renterList = renterDao.findRenterByAll();
		return renterList;
	}

	@Override
	public Renter getRenterByID(Integer RenterID) {
		// TODO 自动生成的方法存根
		Renter renter = renterDao.findRenterByID(RenterID);
		return renter;
	}

	@Override
	public void batchDelRenter(String delIdArray) {
		// TODO 自动生成的方法存根
		renterDao.batchDel(delIdArray);
	}
}
