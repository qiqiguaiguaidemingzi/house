package com.lin.bean;

public class User {
	private String acc;
	private String psd;
	private String realName;
	private String email;
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(){}
	@Override
	public String toString() {
		return "User [acc=" + acc + ", psd=" + psd + ", realName=" + realName + ", email=" + email + "]";
	}
	
	
}
