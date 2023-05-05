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

import com.henzki.postgresql.model.Tuote;
import com.henzki.postgresql.service.TuoteService;

@RestController
@RequestMapping("/api/tuotteet")
public class TuoteController {

	@Autowired
	private TuoteService tuService;
	
	@GetMapping
	public List<Tuote> haeKaikkiTuotteet() {
	    return tuService.haeKaikkiTuotteet();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tuote> haeTuote(@PathVariable("id") Long id) {
		Tuote tuote = tuService.haeTuote(id);
	    if (tuote == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(tuote);
	    }
	}

	@PostMapping
	public ResponseEntity<Tuote> lisaaTuote(@RequestBody Tuote tuote) {
		Tuote uusiTuote = tuService.lisaaTuote(tuote);
	    return ResponseEntity.status(HttpStatus.CREATED).body(uusiTuote);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tuote> paivitaTuote(@PathVariable("id") Long id, @RequestBody Tuote tuote) {
		Tuote paivitettyTuote = tuService.paivitaTuote(id, tuote);
	    if (paivitettyTuote == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(paivitettyTuote);
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> poistaTuote(@PathVariable("id") Long id) {
	    boolean poistettiin = tuService.poistaTuote(id);
	    if (poistettiin) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}