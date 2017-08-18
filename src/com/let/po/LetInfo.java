package com.let.po;

import java.util.Date;
import java.util.Set;

public class LetInfo {
	private Integer id;
	private String letName;
	private HouseInfo houseInfo;//
	private Renter renter;// ���1:�ⷿ��Ϣn
	private Broker broker;// ������1:������Ϣn
	private Date beginTime;// ���޿�ʼʱ��
	private int dayNum;// ����ʱ�䳤��
	private Date endTime;// ���޽���ʱ��

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLetName() {
		return letName;
	}

	public void setLetName(String letName) {
		this.letName = letName;
	}

	public HouseInfo getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}

	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public int getDayNum() {
		return dayNum;
	}

	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
