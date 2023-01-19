package com.devsu.microservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends Person{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	
	private String password;
	
	private boolean state;
	
	public Client(Long idClient, String password, boolean state) {
		super();
		this.idClient = idClient;
		this.password = password;
		this.state = state;
	}
	
	public Client() {
		super();
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
		
}
