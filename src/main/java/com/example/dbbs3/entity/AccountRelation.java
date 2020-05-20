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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_account_relation")
@EntityListeners(AuditingEntityListener.class)
public class AccountRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_relation_generator")
	@SequenceGenerator(name="id_relation_generator", sequenceName = "seq_id_relation", allocationSize=1)
	@Column(name = "id_relation")
	private int idRelation;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "acc_number_main", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Client clientMain;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "acc_number_dest", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Client clientDest;

	public int getIdRelation() {
		return idRelation;
	}

	public void setIdRelation(int idRelation) {
		this.idRelation = idRelation;
	}

	public Client getClientMain() {
		return clientMain;
	}

	public void setClientMain(Client clientMain) {
		this.clientMain = clientMain;
	}

	public Client getClientDest() {
		return clientDest;
	}

	public void setClientDest(Client clientDest) {
		this.clientDest = clientDest;
	}
}
