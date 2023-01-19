package com.devsu.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.microservice.exception.ClientException;
import com.devsu.microservice.service.ClientService;
import com.devsu.microservice.service.dto.ClientDto;
import com.devsu.microservice.utils.ResponseMessage;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping("/clientes/todos")
	public ResponseEntity<List<ClientDto>> getAll() {
		try {
			List<ClientDto> listClientDto = clientService.getAll();
			return new ResponseEntity<>(listClientDto, new HttpHeaders(), HttpStatus.CREATED);
		} catch (ClientException e) {
			return new ResponseEntity<>(null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/clientes/crear")
	public ResponseEntity<ResponseMessage> create(@RequestBody ClientDto clientDto) {
		ResponseMessage responseMessage;
		try {
			responseMessage = clientService.create(clientDto);
			return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.CREATED);
		} catch (ClientException e) {
			return new ResponseEntity<>(new ResponseMessage("Error: " + e.getMessage()), new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/clientes/editar")
	public ResponseEntity<ResponseMessage> edit(@RequestBody ClientDto clientDto) {
		try {
			ResponseMessage responseMessage = clientService.edit(clientDto);
			return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);
		} catch (ClientException e) {
			return new ResponseEntity<>(new ResponseMessage("Error: " + e.getMessage()), new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/clientes/eliminar/{idClient}")
	@Transactional
	public ResponseEntity<ResponseMessage> delete(@PathVariable("idClient") Long idClient) {
		try {
			ResponseMessage responseMessage = clientService.delete(idClient);
			return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);
		} catch (ClientException e) {
			return new ResponseEntity<>(new ResponseMessage("Error: " + e.getMessage()), new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

}
