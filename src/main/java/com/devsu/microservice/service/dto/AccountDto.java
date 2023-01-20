package com.devsu.microservice.service.dto;


public class AccountDto {
	private Long accountNumber;

	private String accountType;

	private float initialAmount;

	private boolean state;

	private ClientDto client;

	public AccountDto() {
		super();
	}

	public AccountDto(Long accountNumber, String accountType, float initialAmount, boolean state,
			ClientDto client) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.initialAmount = initialAmount;
		this.state = state;
		this.client = client;
	}

	public ClientDto getClient() {
		return client;
	}

	public void setClient(ClientDto client) {
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

}
