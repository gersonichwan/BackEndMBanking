package com.example.dbbs3.model;

public class OtpReponse {
	boolean checkAccNumber;
	String token;
	public boolean isCheckAccNumber() {
		return checkAccNumber;
	}
	public void setChekAccNumber(boolean checkAccNumber) {
		this.checkAccNumber = checkAccNumber;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
