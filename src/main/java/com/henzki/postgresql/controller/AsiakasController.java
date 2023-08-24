package com.henzki.postgresql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henzki.postgresql.dto.AsiakasDTO;
import com.henzki.postgresql.service.AsiakasService;

@RestController
@RequestMapping("/api/asiakkaat")
public class AsiakasController {

	@Autowired
	private AsiakasService asService;

	@GetMapping
	public List<AsiakasDTO> haeKaikkiAsiakkaat() {
	    return asService.haeKaikkiAsiakkaat();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AsiakasDTO> haeAsiakas(@PathVariable("id") Long id) {
		AsiakasDTO asiakas = asService.haeAsiakas(id);
	    if (asiakas == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(asiakas);
	    }
	}

	@PostMapping
	public ResponseEntity<AsiakasDTO> lisaaAsiakas(@RequestBody AsiakasDTO asiakas) {
		AsiakasDTO uusiAsiakas = asService.lisaaAsiakas(asiakas);
	    return ResponseEntity.status(HttpStatus.CREATED).body(uusiAsiakas);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AsiakasDTO> paivitaAsiakas(@PathVariable("id") Long id, @RequestBody AsiakasDTO asiakas) {
		AsiakasDTO paivitettyAsiakas = asService.paivitaAsiakas(id, asiakas);
	    if (paivitettyAsiakas == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(paivitettyAsiakas);
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> poistaAsiakas(@PathVariable("id") Long id) {
	    boolean poistettiin = asService.poistaAsiakas(id);
	    if (poistettiin) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}