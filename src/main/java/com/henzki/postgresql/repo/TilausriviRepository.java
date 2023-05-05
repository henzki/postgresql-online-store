package com.henzki.postgresql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henzki.postgresql.model.Tilausrivi;

public interface TilausriviRepository extends JpaRepository<Tilausrivi, Long> {

}
