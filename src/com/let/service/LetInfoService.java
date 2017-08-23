package com.let.service;

import java.util.List;

import com.let.po.LetInfo;

public interface LetInfoService {
	public void addLet(LetInfo letInfo);

	public void updateLet(LetInfo letInfo);

	public void deleteLet(Integer LetID);

	public List<LetInfo> getLetByAll();

	public LetInfo getLetByID(Integer LetID);
	
	public void batchDelLet(String delIdArray);
}
