package com.devsu.microservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.microservice.domain.Client;
import com.devsu.microservice.exception.ClientException;
import com.devsu.microservice.repository.ClientRepository;
import com.devsu.microservice.service.ClientService;
import com.devsu.microservice.service.dto.ClientDto;
import com.devsu.microservice.service.mapper.ClientMapper;
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
	public List<ClientDto> getAll() throws ClientException {
		List<Client> clients = clientRepository.findAll();
		return clientMapper.listClientToListClientDto(clients);
	}
	
	@Override
	public ClientDto getById(Long idClient) throws ClientException {
		Optional<Client> client = clientRepository.findById(idClient);
		if(client.isPresent())
			return clientMapper.clientToClientDto(client.get());
	
		return null;
	}
	
	@Override
	public ClientDto findByIdentification(String identification) throws ClientException {
		Optional<Client> client = clientRepository.findByIdentification(identification);
		if(client.isPresent())
			return clientMapper.clientToClientDto(client.get());
	
		return null;
	}
	
	@Override
	public ResponseMessage create(ClientDto clientDto) throws ClientException{	
		Optional<Client> clientTemp = clientRepository.findByIdClient(clientDto.getIdClient());

		if (clientTemp.isPresent()) {
			return new ResponseMessage("El cliente con ID: " + clientDto.getIdClient() + " ya existe");
		} else {
			clientRepository.save(clientMapper.clientDtoToClient(clientDto));
			return new ResponseMessage("Cliente creado con exito");
		}
	}

	@Override
	public ResponseMessage edit(ClientDto clientDto) throws ClientException{
		Optional<Client> clientTemp = clientRepository.findByIdClient(clientDto.getIdClient());

		if (clientTemp.isPresent()) {
			clientRepository.save(clientMapper.clientDtoToClient(clientDto));
			return (new ResponseMessage("Cliente actualizado con exito"));
		} else
			return (new ResponseMessage("Error al actualizar cliente"));
	}

	@Override
	public ResponseMessage delete(Long idCLient) throws ClientException{
		Optional<Client> clientTemp = clientRepository.findByIdClient(idCLient);

		if (clientTemp.isPresent()) {
			clientRepository.deleteByIdClient(idCLient);
			return (new ResponseMessage("Cliente eliminado con exito"));
		}else {
			return (new ResponseMessage("EL cliente con ID: " + idCLient + " no fue encontrado"));
		}
	}

}
