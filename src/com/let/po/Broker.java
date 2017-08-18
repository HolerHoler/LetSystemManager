package com.let.po;

import java.util.Set;

public class Broker extends Person {
	private String work_address;// 工作地址
	private Set<BrokerHouse> brokerHouse;// 房子信息（两个一对多）

	private Set<LetInfo> letInfos;// 经纪人1:租屋信息n

	public Broker() {
		super();
	}

	public String getWork_address() {
		return work_address;
	}

	public void setWork_address(String work_address) {
		this.work_address = work_address;
	}

	public Set<BrokerHouse> getBrokerHouse() {
		return brokerHouse;
	}

	public void setBrokerHouse(Set<BrokerHouse> brokerHouse) {
		this.brokerHouse = brokerHouse;
	}

	public Set<LetInfo> getLetInfos() {
		return letInfos;
	}

	public void setLetInfos(Set<LetInfo> letInfos) {
		this.letInfos = letInfos;
	}

}
