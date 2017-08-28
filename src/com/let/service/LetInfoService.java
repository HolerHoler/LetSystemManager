package com.let.service;

import java.util.List;

import com.let.po.LetInfo;

public interface LetInfoService {
	public void addLet(LetInfo letInfo);

	public void updateLet(LetInfo letInfo);

	public void deleteLet(Long LetID);

	public List<LetInfo> getLetByAll();

	public LetInfo getLetByID(Long LetID);
	
	public void batchDelLet(String delIdArray);
}
