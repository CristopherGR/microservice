package com.devsu.microservice.service.dto;

import com.devsu.microservice.domain.enums.AccountType;

public class AccountDto {
	private String accountNumber;

	private AccountType accountType;

	private float openingBalance;

	private boolean state;

	private ClientDto client;

	public AccountDto() {
		super();
	}

	public AccountDto(String accountNumber, AccountType accountType, float openingBalance, boolean state,
			ClientDto client) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.openingBalance = openingBalance;
		this.state = state;
		this.client = client;
	}

	public ClientDto getClient() {
		return client;
	}

	public void setClient(ClientDto client) {
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

}
