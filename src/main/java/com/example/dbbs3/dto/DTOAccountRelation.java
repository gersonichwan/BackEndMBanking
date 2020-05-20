package com.example.dbbs3.dto;

public class DTOAccountRelation {

	private int accNumberDest;
	private String fullName;
	
	public DTOAccountRelation(int accNumberDest, String fullName) {
		super();
		this.accNumberDest = accNumberDest;
		this.fullName = fullName;
	}

	public int getAccNumberDest() {
		return accNumberDest;
	}

	public void setAccNumberDest(int accNumberDest) {
		this.accNumberDest = accNumberDest;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
