package com.let.po;

import java.util.Set;

public class HouseInfo {
	private Long id;
	private String houseName;// ��������
	private String type;// ��������
	private String design;// �������
	private double size;// ���Ӵ�С
	private double rent;// ���
	private String rent_method;// ���޷�ʽ(���⣬����)
	private String rent_remand;// ����Ҫ��
	private String direction;// ���ӳ���
	private String address;// ���ӵ�ַ
	private String floor; // ��������¥��
	private String decoration;// װ��
	private String facilities;// ����
	private String description;// ����
	private char state;// ����״̬
	private Set<LetInfo> letInfos;// ������Ϣ1��������Ϣn
	private Set<BrokerHouse> brokerHouse;// ��������Ϣ������һ�Զࣩ

	public HouseInfo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getRent_method() {
		return rent_method;
	}

	public void setRent_method(String rent_method) {
		this.rent_method = rent_method;
	}

	public String getRent_remand() {
		return rent_remand;
	}

	public void setRent_remand(String rent_remand) {
		this.rent_remand = rent_remand;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

	public Set<LetInfo> getLetInfos() {
		return letInfos;
	}

	public void setLetInfos(Set<LetInfo> letInfos) {
		this.letInfos = letInfos;
	}

	public Set<BrokerHouse> getBrokerHouse() {
		return brokerHouse;
	}

	public void setBrokerHouse(Set<BrokerHouse> brokerHouse) {
		this.brokerHouse = brokerHouse;
	}

}
