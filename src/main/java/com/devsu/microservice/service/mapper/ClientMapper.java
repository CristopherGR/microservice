package com.devsu.microservice.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.devsu.microservice.domain.Client;
import com.devsu.microservice.service.dto.ClientDto;

public class ClientMapper {

	public Client clientDtoToClient(ClientDto clientDto) {

		if (clientDto == null) {
			return null;
		}

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

	public ClientDto clientToClientDto(Client client) {

		if (client == null) {
			return null;
		}

		ClientDto clientDto = new ClientDto();
		clientDto.setIdentification(client.getIdentification());
		clientDto.setName(client.getName());
		clientDto.setGender(client.getGender());
		clientDto.setAge(client.getAge());
		clientDto.setAddress(client.getAddress());
		clientDto.setPhone(client.getPhone());
		clientDto.setPassword(client.getPassword());
		clientDto.setState(client.isState());
		return clientDto;
	}

	public List<ClientDto> listClientToListClientDto(List<Client> listClient) {

		if (listClient.isEmpty()) {
			return null;
		}
		
		List<ClientDto> listClientDto = new ArrayList<>();
		
		for(Client client : listClient) {
			ClientDto clientDto = new ClientDto();
			clientDto.setIdClient(client.getIdClient());
			clientDto.setIdentification(client.getIdentification());
			clientDto.setName(client.getName());
			clientDto.setGender(client.getGender());
			clientDto.setAge(client.getAge());
			clientDto.setAddress(client.getAddress());
			clientDto.setPhone(client.getPhone());
			clientDto.setPassword(client.getPassword());
			clientDto.setState(client.isState());
			listClientDto.add(clientDto);
		}	
		return listClientDto;
	}
}
