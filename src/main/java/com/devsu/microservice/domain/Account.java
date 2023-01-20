package com.devsu.microservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;
	
	private String  accountType;
	
	private float  initialAmount;
	
	private boolean state;

	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	
	public Account() {
		super();
	}
	
	public Account(Long accountNumber, String accountType, float openingBalance, boolean state, Client client) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.initialAmount = openingBalance;
		this.state = state;
		this.client = client;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getInitialAmount() {
		return initialAmount;
	}

	public void setInitialAmount(float initialAmount) {
		this.initialAmount = initialAmount;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
