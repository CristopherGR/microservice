package com.devsu.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.microservice.domain.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {
	
	Optional<Movement> findByMovementId(Long movementId);
	
	void deleteByMovementId(Long movementId);

}
