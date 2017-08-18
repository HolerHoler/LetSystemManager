package com.let.po;

import java.util.Date;
import java.util.Set;

public class LetInfo {
	private Integer id;
	private String letName;
	private HouseInfo houseInfo;//
	private Renter renter;// 租客1:租房信息n
	private Broker broker;// 经纪人1:租屋信息n
	private Date beginTime;// 租赁开始时间
	private int dayNum;// 租赁时间长度
	private Date endTime;// 租赁结束时间

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
