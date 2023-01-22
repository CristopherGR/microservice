package com.devsu.microservice.service;

import java.util.List;

import com.devsu.microservice.exception.AccountException;
import com.devsu.microservice.exception.MovementException;
import com.devsu.microservice.service.dto.MovementDto;
import com.devsu.microservice.utils.ResponseMessage;

public interface MovementService {

	public List<MovementDto> getAll() throws MovementException;

	public MovementDto getById(Long movementId) throws MovementException;

	public ResponseMessage create(MovementDto movementDto) throws MovementException, AccountException;

	public ResponseMessage edit(MovementDto movementDto) throws MovementException;

	public ResponseMessage delete(Long movementId) throws MovementException;
}
