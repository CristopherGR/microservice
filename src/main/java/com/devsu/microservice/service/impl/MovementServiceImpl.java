package com.devsu.microservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.microservice.domain.Account;
import com.devsu.microservice.domain.Movement;
import com.devsu.microservice.exception.AccountException;
import com.devsu.microservice.repository.MovementRepository;
import com.devsu.microservice.service.AccountService;
import com.devsu.microservice.service.MovementService;
import com.devsu.microservice.service.dto.MovementDto;
import com.devsu.microservice.service.mapper.MovementMapper;
import com.devsu.microservice.utils.ResponseMessage;

@Service
public class MovementServiceImpl implements MovementService {

	@Autowired
	private MovementRepository movementRepository;
	
	@Autowired
	private AccountService accountService;

	private MovementMapper movementMapper;

	public MovementServiceImpl() {
		super();
		movementMapper = new MovementMapper();
	}

	@Override
	public List<MovementDto> getAll() throws AccountException {
		List<Movement> movementList = movementRepository.findAll();
		return (movementMapper.movementListToMovementDtoList(movementList));
	}

	@Override
	public ResponseMessage create(MovementDto movementDto) throws AccountException {

		if((!movementDto.getMovementType().equals("Credito")) && !(movementDto.getMovementType().equals("Debito"))) {
			return (new ResponseMessage("Tipo de movimiento incorrecto"));
		}
		
		List<Movement> movementList = movementRepository.getAllMovementsByAccount(movementDto.getAccount().getAccountNumber());
		float totalAmount = accountService.getInitialAmountById(movementDto.getAccount().getAccountNumber());

		for (Movement movement : movementList) {
			if("Credito".equals(movement.getMovementType()))
				totalAmount += movement.getValue();
			else
				totalAmount += (movement.getValue()*-1);
		}
		
		if("Credito".equals(movementDto.getMovementType()))
			totalAmount += movementDto.getValue();
		else
			totalAmount += (movementDto.getValue()*-1);
				
		if(totalAmount < 0)
			return (new ResponseMessage("Saldo no disponible"));
		
		movementDto.setTotalAmount(totalAmount);
		movementRepository.save(movementMapper.movementDtoToMovement(movementDto));
		return (new ResponseMessage("Movimiento registrado con exito"));

	}

	@Override
	public ResponseMessage edit(MovementDto movementDto) throws AccountException {
		Optional<Movement> movementTemp = movementRepository.findByMovementId(movementDto.getMovementId());

		if (movementTemp.isPresent()) {
			movementRepository.save(movementMapper.movementDtoToMovement(movementDto));
			return (new ResponseMessage("Movimiento actualizado con exito"));
		} else {
			return (new ResponseMessage("Error al actualizar el movimiento"));
		}
	}

	@Override
	public ResponseMessage delete(Long movementId) throws AccountException {
		Optional<Movement> movementTemp = movementRepository.findByMovementId(movementId);

		if (movementTemp.isPresent()) {
			movementRepository.deleteByMovementId(movementId);
			return (new ResponseMessage("Movimiento eliminado con exito"));
		} else {
			return (new ResponseMessage("EL movimiento con ID: " + movementId + " no fue encontrado"));
		}
	}

}
