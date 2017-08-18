package com.let.po;

public class BrokerHouse {
	private Integer id;
	private HouseInfo house;
	private Broker broker;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HouseInfo getHouse() {
		return house;
	}

	public void setHouse(HouseInfo house) {
		this.house = house;
	}

	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}
}
