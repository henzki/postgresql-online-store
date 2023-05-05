package com.henzki.postgresql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henzki.postgresql.model.Tilaus;

public interface TilausRepository extends JpaRepository<Tilaus, Long> {

}
