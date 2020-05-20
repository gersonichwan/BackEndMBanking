package com.example.dbbs3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="temp_otp")
public class TempOtp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_temp_otp")
	private long idTempRegis;
	
	@Column(name="exp_date")
	private Date expDate;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="token")
	private String token;
	
	@Column(name = "acc_number")
	private int accNumber;
	
	public TempOtp() {
		// TODO Auto-generated constructor stub
	}

	public TempOtp(long idTempRegis, Date expDate, Date createdDate, String token, int accNumber) {
		super();
		this.idTempRegis = idTempRegis;
		this.expDate = expDate;
		this.createdDate = createdDate;
		this.token = token;
		this.accNumber = accNumber;
	}

	public long getIdTempRegis() {
		return idTempRegis;
	}

	public void setIdTempRegis(long idTempRegis) {
		this.idTempRegis = idTempRegis;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	
	
	
}
