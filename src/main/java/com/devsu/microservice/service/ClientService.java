package com.devsu.microservice.service;

import java.util.List;

import com.devsu.microservice.exception.ClientException;
import com.devsu.microservice.service.dto.ClientDto;
import com.devsu.microservice.utils.ResponseMessage;

public interface ClientService {
	
	public List<ClientDto> getAll() throws ClientException;

	public ClientDto getById(Long idClient) throws ClientException;
	
	public ClientDto findByIdentification(String identification) throws ClientException;

	public ResponseMessage create(ClientDto clientDto) throws ClientException;

	public ResponseMessage edit(ClientDto clientDto) throws ClientException;

	public ResponseMessage delete(Long idClient) throws ClientException;
}
