package com.lin.dto;

public class CheckHouseState {	//用户查看房屋状态
	private String houseNum;
	
	private String houseName;
	
	private int state;

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "CheckHouseState [houseNum=" + houseNum + ", houseName=" + houseName + ", state=" + state + "]";
	}
	
	
}
