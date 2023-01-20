package com.devsu.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsu.microservice.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Optional<Account> findByAccountNumber(Long accountNumber);

	void deleteByAccountNumber(Long accountNumber);
}
