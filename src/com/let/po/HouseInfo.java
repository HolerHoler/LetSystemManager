package com.let.po;

import java.util.Set;

public class HouseInfo {
	private Long id;
	private String houseName;// 房子名字
	private String type;// 房子类型
	private String design;// 房子设计
	private double size;// 房子大小
	private double rent;// 租金
	private String rent_method;// 租赁方式(合租，整租)
	private String rent_remand;// 租赁要求
	private String direction;// 房子朝向
	private String address;// 房子地址
	private String floor; // 房子所在楼层
	private String decoration;// 装修
	private String facilities;// 配套
	private String description;// 描述
	private char state;// 出租状态
	private Set<LetInfo> letInfos;// 房子信息1：出租信息n
	private Set<BrokerHouse> brokerHouse;// 经纪人信息（两个一对多）

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
