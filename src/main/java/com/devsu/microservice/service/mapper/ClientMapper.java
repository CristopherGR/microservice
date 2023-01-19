package com.devsu.microservice.service.mapper;

import com.devsu.microservice.domain.Client;
import com.devsu.microservice.service.dto.ClientDto;

public class ClientMapper {

	public Client clientDtoToClient(ClientDto clientDto) {
		Client client = new Client();
		client.setIdentification(clientDto.getIdentification());
		client.setName(clientDto.getName());
		client.setGender(clientDto.getGender());
		client.setAge(clientDto.getAge());
		client.setAddress(clientDto.getAddress());
		client.setPhone(clientDto.getPhone());
		client.setPassword(clientDto.getPassword());
		client.setState(clientDto.isState());
		client.setIdClient(clientDto.getIdClient());
		
		return client;		
	}
	
	public ClientDto clientToClientDto(Client clien) {
		ClientDto clientDto = new ClientDto();
		clientDto.setIdentification(clien.getIdentification());
		clientDto.setName(clien.getName());
		clientDto.setGender(clien.getGender());
		clientDto.setAge(clien.getAge());
		clientDto.setAddress(clien.getAddress());
		clientDto.setPhone(clien.getPhone());
		clientDto.setPassword(clien.getPassword());
		clientDto.setState(clien.isState());
		
		return clientDto;	
	}
	
}
