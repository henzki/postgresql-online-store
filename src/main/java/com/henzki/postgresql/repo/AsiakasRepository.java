package com.henzki.postgresql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henzki.postgresql.model.Asiakas;

public interface AsiakasRepository extends JpaRepository<Asiakas, Long> {
	
}
