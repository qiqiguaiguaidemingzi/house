package com.lin.bean;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class HouseInfo {
	
	
	private String houseName;	//房屋名
	private String price; 		//房屋价格
	private int houseNum;	//房屋编号
	private String address; 	//地址
	private String area;		//面积
	private String message;		//简介
	private String type;		//房屋类型
	private int state;		//房屋状态 ：1代表申请上架，2代表已上架，3代表申请下架
	private String imgUrl;
	private String[] houseImg;
	
	public String[] getHouseImg() {
		return houseImg;
	}
	public void setHouseImg(String[] houseImg) {
		this.houseImg = houseImg;
	}
	private String acc;
	
	
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public HouseInfo(){}
	@Override
	public String toString() {
		return "HouseInfo [houseName=" + houseName + ", price=" + price + ", houseNum=" + houseNum + ", address="
				+ address + ", area=" + area + ", message=" + message + ", type=" + type + ", state=" + state
				+ ", imgUrl=" + imgUrl + ", acc=" + acc + "]";
	}
	
	
}
