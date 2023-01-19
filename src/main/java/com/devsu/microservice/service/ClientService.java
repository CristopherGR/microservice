package com.devsu.microservice.service;

import com.devsu.microservice.service.dto.ClientDto;
import com.devsu.microservice.utils.ResponseMessage;

public interface ClientService {
	public ResponseMessage create(ClientDto clientDto);
	public ResponseMessage update(ClientDto clientDto);
	public ResponseMessage delete(ClientDto clientDto);
}
