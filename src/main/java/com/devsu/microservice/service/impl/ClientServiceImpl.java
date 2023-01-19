package com.devsu.microservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.microservice.domain.Client;
import com.devsu.microservice.repository.ClientRepository;
import com.devsu.microservice.service.ClientService;
import com.devsu.microservice.service.dto.ClientDto;
import com.devsu.microservice.service.mapper.ClientMapper;
import com.devsu.microservice.utils.Constants;
import com.devsu.microservice.utils.ResponseMessage;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	private ClientMapper clientMapper;
	
	public ClientServiceImpl() {
		super();
		this.clientMapper = new ClientMapper();
	}
	
	@Override
	public ResponseMessage create(ClientDto clientDto) {
		Client client = clientMapper.clientDtoToClient(clientDto);
		clientRepository.save(client); 
		return (new ResponseMessage(Constants.CLIENT_CREATED));
	}

	@Override
	public ResponseMessage update(ClientDto clientDto) {
		Client client = clientMapper.clientDtoToClient(clientDto);
		Optional<Client> clientTemp = clientRepository.findByIdClient(client.getClientId());
		
		if(clientTemp.isPresent()) {
			clientRepository.save(clientMapper.clientDtoToClient(clientDto));
			return (new ResponseMessage(Constants.CLIENT_UPDATED));
		}else 
			return (new ResponseMessage(Constants.CLIENT_UPDATED_FAIL));
		
	}

	@Override
	public ResponseMessage delete(ClientDto clientDto) {
		// TODO Auto-generated method stub
		return null;
	}


}
