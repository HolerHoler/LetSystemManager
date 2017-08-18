package com.let.dao;

import java.util.List;

import com.let.po.Renter;

public interface RenterDao {
	public void addRenterToDB(Renter renter);

	public void updateRenterToDB(Renter renter);

	public void deleteRenterToDB(Renter renter);

	public List findRenterByAll();

	public Renter findRenterByID(Integer RenterID);
}
