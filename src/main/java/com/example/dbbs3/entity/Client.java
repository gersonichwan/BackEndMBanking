package com.example.dbbs3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tbl_client")
@EntityListeners(AuditingEntityListener.class)
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acc_number_generator")
	@SequenceGenerator(name="acc_number_generator", sequenceName = "seq_acc_number", allocationSize=1)
	@Column(name = "acc_number")
	private int accNumber;
	
	@Column(name = "pin", nullable = false)
	private String pin;
	
	@Column(name = "balance", nullable = false)
	private int balance;
	
	@Column(name = "id_card", nullable = false)
	private String idCard;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Column(name = "mobile_phone", nullable = false)
	private String mobilePhone;
	
	@Column(name = "email", nullable = false)
	private String email;

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
