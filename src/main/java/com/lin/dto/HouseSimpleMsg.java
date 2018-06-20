package com.lin.dto;

public class HouseSimpleMsg {
	
	private String houseNum;
	private String acc;
	private String tel;
	private String manager;
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "HouseSimpleMsg [houseNum=" + houseNum + ", acc=" + acc + ", tel=" + tel + ", manager=" + manager + "]";
	}
	
	
}
