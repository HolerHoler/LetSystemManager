package com.let.service;

import java.util.List;

import com.let.po.Renter;

public interface RenterService {
	public void addRenter(Renter renter);

	public void updateRenter(Renter renter);

	public void deleteRenter(Integer RenterID);

	public List<Renter> getRenterByAll();

	public Renter getRenterByID(Integer RenterID);

	public void batchDelRenter(String delIdArray);

}
