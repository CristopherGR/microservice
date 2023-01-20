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

import com.devsu.microservice.service.MovementService;
import com.devsu.microservice.service.dto.MovementDto;
import com.devsu.microservice.utils.ResponseMessage;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MovementController {

	@Autowired
	private MovementService movementService;

	@GetMapping("/movimientos/todos")
	public ResponseEntity<List<MovementDto>> getAll() {
		try {
			List<MovementDto> movementDtoList = movementService.getAll();
			return new ResponseEntity<>(movementDtoList, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/movimientos/crear")
	public ResponseEntity<ResponseMessage> create(@RequestBody MovementDto movementDto) {
		try {
			ResponseMessage responseMessage = movementService.create(movementDto);
			return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseMessage("Error: " + e.getMessage()), new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/movimientos/editar")
	public ResponseEntity<ResponseMessage> editar(@RequestBody MovementDto movementDto) {
		try {
			ResponseMessage responseMessage = movementService.edit(movementDto);
			return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseMessage("Error: " + e.getMessage()), new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/movimientos/eliminar/{movementId}")
	@Transactional
	public ResponseEntity<ResponseMessage> eliminar(@PathVariable("movementId") Long movementId){
		try {
			ResponseMessage responseMessage = movementService.delete(movementId);
			return new ResponseEntity<>(responseMessage, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseMessage("Error: " + e.getMessage()), new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

}
