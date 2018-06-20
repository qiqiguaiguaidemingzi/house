package com.lin.dto;

public class AcceptUpMsg {		//接受房屋上架信息
	
	private String houseNum;
	
	private String manager;

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "AcceptUpMsg [houseNum=" + houseNum + ", manager=" + manager + "]";
	}
	
	
}
