package com.devsu.microservice.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.devsu.microservice.domain.Movement;
import com.devsu.microservice.service.dto.MovementDto;

public class MovementMapper {

	private AccountMapper accountMapper;

	public MovementMapper() {
		super();
		accountMapper = new AccountMapper();
	}
	
	public Movement movementDtoToMovement(MovementDto movementDto) {
		
		if(movementDto == null) {
			return null;
		}
		
		Movement movement = new Movement();
		movement.setMovementId(movementDto.getMovementId());
		movement.setMovementType(movementDto.getMovementType());
		movement.setDate(movementDto.getDate());
		movement.setValue(movementDto.getValue());
		movement.setTotalAmount(movementDto.getTotalAmount());
		movement.setAccount(accountMapper.accountDtoToAccount(movementDto.getAccount()));
		return movement;		
	}
	
	public MovementDto movementToMovementDto(Movement movement) {
		
		if(movement == null) {
			return null;
		}
		
		MovementDto movementDto = new MovementDto();
		movementDto.setMovementId(movement.getMovementId());
		movementDto.setMovementType(movement.getMovementType());
		movementDto.setDate(movement.getDate());
		movementDto.setValue(movement.getValue());
		movementDto.setTotalAmount(movement.getTotalAmount());
		movementDto.setAccount(accountMapper.accountToAccountDto(movement.getAccount()));
		return movementDto;	
	}
	
	/**
	 * se vuelve a usar la funcion movementToMovementDto() 
	 * para no volver a escribir las mismas lineas de codigo
	 * dentro del for, luego se usa directamente movementDtoList.add()
	 */
	public List<MovementDto> movementListToMovementDtoList(List<Movement> movementList){
		
		if(movementList.isEmpty()) {
			return null;
		}
		
		List<MovementDto> movementDtoList = new ArrayList<>();
		
		for(Movement movement : movementList) {
			movementDtoList.add(movementToMovementDto(movement));
		}
		
		return movementDtoList;
	}
	
}
