package com.example.dbbs3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.dbbs3.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_transaction")
public class Transaction extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_transaction_generator")
	@SequenceGenerator(name="id_transaction_generator", sequenceName = "seq_id_transaction", allocationSize=1)
	@Column(name = "id_transaction")
	private int idTransaction;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "acc_number_sender", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Client clientSender;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "acc_number_receiver", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Client clientReceiver;

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Client getClientSender() {
		return clientSender;
	}

	public void setClientSender(Client clientSender) {
		this.clientSender = clientSender;
	}

	public Client getClientReceiver() {
		return clientReceiver;
	}

	public void setClientReceiver(Client clientReceiver) {
		this.clientReceiver = clientReceiver;
	}
}
