package com.example.dbbs3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.dbbs3.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_history_client")
@EntityListeners(AuditingEntityListener.class)
public class HistoryClient extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_history_generator")
	@SequenceGenerator(name="id_history_generator", sequenceName = "seq_id_history", allocationSize=1)
	@Column(name = "id_history")
	private int idHistory;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "acc_number", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_transaction", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Transaction transaction;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "note", nullable = true)
	private String note;

	public void setNote(String note) {
		this.note = note;
	}

	public int getIdHistory() {
		return idHistory;
	}

	public void setIdHistory(int idHistory) {
		this.idHistory = idHistory;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}
}
