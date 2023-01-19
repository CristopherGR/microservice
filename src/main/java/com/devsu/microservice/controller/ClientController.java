package com.devsu.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.microservice.service.ClientService;
import com.devsu.microservice.service.dto.ClientDto;
import com.devsu.microservice.utils.ResponseMessage;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@PostMapping("/client/create")
	public ResponseEntity<ResponseMessage> create(@RequestBody ClientDto clientDto){
		ResponseMessage responseMessage = clientService.create(clientDto);
		return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/client/edit")
	public ResponseEntity<ResponseMessage> edit(@RequestBody ClientDto clientDto){
		ResponseMessage responseMessage = clientService.edit(clientDto);
		return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/cuentas/eliminar/{id}")
	@Transactional
	public ResponseEntity<ResponseMessage> delete(@PathVariable("id") Long idClient) {
		ResponseMessage responseMessage;
		responseMessage = clientService.delete(idClient);
		return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);

	}
}
