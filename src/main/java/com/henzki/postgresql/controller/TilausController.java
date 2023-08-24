package com.henzki.postgresql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henzki.postgresql.dto.TilausDTO;
import com.henzki.postgresql.model.Tilaus;
import com.henzki.postgresql.service.TilausService;

@RestController
@RequestMapping("/api/tilaukset")
public class TilausController {

	@Autowired
	private TilausService tiService;
	
	@GetMapping
	public List<TilausDTO> haeKaikkiTilaukset() {
	    return tiService.haeKaikkiTilaukset();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TilausDTO> haeTilaus(@PathVariable("id") Long id) {
		TilausDTO tilausDTO = tiService.haeTilaus(id);
	    if (tilausDTO == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(tilausDTO);
	    }
	}

	@PostMapping
	public ResponseEntity<TilausDTO> lisaaTilaus(@RequestBody TilausDTO tilausDTO) {
		TilausDTO uusiTilaus = tiService.lisaaTilaus(tilausDTO);
	    return ResponseEntity.status(HttpStatus.CREATED).body(uusiTilaus);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TilausDTO> paivitaTilaus(@PathVariable("id") Long id, @RequestBody TilausDTO tilausDTO) {
	    TilausDTO paivitettyTilaus = tiService.paivitaTilaus(id, tilausDTO);
	    if (paivitettyTilaus == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(paivitettyTilaus);
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> poistaTilaus(@PathVariable("id") Long id) {
	    boolean poistettiin = tiService.poistaTilaus(id);
	    if (poistettiin) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}