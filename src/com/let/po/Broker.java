package com.let.po;

import java.util.Set;

public class Broker extends Person {
	private String work_address;// ������ַ
	private Set<BrokerHouse> brokerHouse;// ������Ϣ������һ�Զࣩ

	private Set<LetInfo> letInfos;// ������1:������Ϣn

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
