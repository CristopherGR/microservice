package com.devsu.microservice.domain;

import com.devsu.microservice.domain.enums.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	private String accountNumber;
	
	private AccountType  accountType;
	
	private float  openingBalance;
	
	private boolean state;

	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;
	
	

	public Account() {
		super();
	}

	public Account(String accountNumber, AccountType accountType, float openingBalance, boolean state, Client client) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.openingBalance = openingBalance;
		this.state = state;
		this.client = client;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public float getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(float openingBalance) {
		this.openingBalance = openingBalance;
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
