package com.devsu.microservice.service;

import java.util.List;

import com.devsu.microservice.exception.AccountException;
import com.devsu.microservice.service.dto.MovementDto;
import com.devsu.microservice.utils.ResponseMessage;

public interface MovementService {
	
	public List<MovementDto> getAll() throws AccountException;
	
	public ResponseMessage create(MovementDto movementDto) throws AccountException;
	
	public ResponseMessage edit(MovementDto movementDto) throws AccountException;
	
	public ResponseMessage delete(Long movementId) throws AccountException;
}
