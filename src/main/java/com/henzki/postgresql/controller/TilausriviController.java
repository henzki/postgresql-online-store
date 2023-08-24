package com.henzki.postgresql.controller;

import java.util.List;

import com.henzki.postgresql.dto.TilausriviDTO;
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

import com.henzki.postgresql.model.Tilausrivi;
import com.henzki.postgresql.service.TilausriviService;

@RestController
@RequestMapping("/api/tilausrivit")
public class TilausriviController {

	@Autowired
	private TilausriviService tiriService;
	
	@GetMapping
	public List<TilausriviDTO> haeKaikkiTilausrivit() {
	    return tiriService.haeKaikkiTilausrivit();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TilausriviDTO> haeTilausrivi(@PathVariable("id") Long id) {
		TilausriviDTO tilausriviDTO = tiriService.haeTilausrivi(id);
	    if (tilausriviDTO == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(tilausriviDTO);
	    }
	}

	@PostMapping
	public ResponseEntity<TilausriviDTO> lisaaTilausrivi(@RequestBody TilausriviDTO tilausriviDTO) {
		TilausriviDTO uusiTilausrivi = tiriService.lisaaTilausrivi(tilausriviDTO);
	    return ResponseEntity.status(HttpStatus.CREATED).body(uusiTilausrivi);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TilausriviDTO> paivitaTilausrivi(@PathVariable("id") Long id, @RequestBody TilausriviDTO tilausriviDTO) {
		TilausriviDTO paivitettyTilausrivi = tiriService.paivitaTilausrivi(id, tilausriviDTO);
	    if (paivitettyTilausrivi == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(paivitettyTilausrivi);
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> poistaTilausrivi(@PathVariable("id") Long id) {
	    boolean poistettiin = tiriService.poistaTilausrivi(id);
	    if (poistettiin) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}