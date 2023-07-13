package com.mattia_stage.Jpa_Implementazione;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findById(long id);
	List<Customer> findByLastName(String lastName);
	List<Customer> findByFirstName(String firstName);
	Customer findByEmail(String email);
	
	boolean existsByEmail(String email);
	boolean existsByLastName(String lastName);
	int countByLastName(String lastName);
}
