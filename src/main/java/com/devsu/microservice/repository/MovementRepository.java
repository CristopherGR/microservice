package com.devsu.microservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsu.microservice.domain.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {
	
	Optional<Movement> findByMovementId(Long movementId);
	
	void deleteByMovementId(Long movementId);

	@Query(value = "select * from movement where account_number = ?1", nativeQuery = true)
	List<Movement> getAllMovementsByAccount(Long accountNumber);	
}
