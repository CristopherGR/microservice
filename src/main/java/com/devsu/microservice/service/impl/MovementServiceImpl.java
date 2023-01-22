package com.devsu.microservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.microservice.domain.Movement;
import com.devsu.microservice.exception.AccountException;
import com.devsu.microservice.exception.MovementException;
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
	public List<MovementDto> getAll() throws MovementException {
		List<Movement> movementList = movementRepository.findAll();
		return (movementMapper.movementListToMovementDtoList(movementList));
	}

	@Override
	public MovementDto getById(Long movementId) throws MovementException {
		Optional<Movement> movement = movementRepository.findById(movementId);
		if(movement.isPresent())
			return movementMapper.movementToMovementDto(movement.get());
	
		return null;
	}
	
	/**
	 * Este servicio primero valida si el tipo de movimiento es Debito o Credito, luego
	 * suma el valor de todos los movimientos de esa cuenta mas el nuevo movimiento ingresado
	 * y obtiene el saldo actual del cliente. Si el saldo es menor que cero se rechaza.
	 * @throws AccountException 
	 */
	@Override
	public ResponseMessage create(MovementDto movementDto) throws MovementException, AccountException {

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
	public ResponseMessage edit(MovementDto movementDto) throws MovementException {
		Optional<Movement> movementTemp = movementRepository.findByMovementId(movementDto.getMovementId());

		if (movementTemp.isPresent()) {
			movementRepository.save(movementMapper.movementDtoToMovement(movementDto));
			return (new ResponseMessage("Movimiento actualizado con exito"));
		} else {
			return (new ResponseMessage("Error al actualizar el movimiento"));
		}
	}

	@Override
	public ResponseMessage delete(Long movementId) throws MovementException {
		Optional<Movement> movementTemp = movementRepository.findByMovementId(movementId);

		if (movementTemp.isPresent()) {
			movementRepository.deleteByMovementId(movementId);
			return (new ResponseMessage("Movimiento eliminado con exito"));
		} else {
			return (new ResponseMessage("EL movimiento con ID: " + movementId + " no fue encontrado"));
		}
	}

}
