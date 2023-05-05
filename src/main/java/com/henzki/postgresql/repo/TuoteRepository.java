package com.henzki.postgresql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henzki.postgresql.model.Tuote;

public interface TuoteRepository extends JpaRepository<Tuote, Long> {

}
