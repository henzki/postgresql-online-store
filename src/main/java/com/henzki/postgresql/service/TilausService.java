package com.henzki.postgresql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzki.postgresql.model.Tilaus;
import com.henzki.postgresql.repo.TilausRepository;

@Service
public class TilausService {

    private final TilausRepository tiRepository;

    @Autowired
    public TilausService(TilausRepository tilausRepository) {
        this.tiRepository = tilausRepository;
    }
    
    public List<Tilaus> haeKaikkiTilaukset() {
        return tiRepository.findAll();
    }

    public Tilaus haeTilaus(Long id) {
        Optional<Tilaus> optionalTilaus = tiRepository.findById(id);
        return optionalTilaus.orElse(null);
    }

    public Tilaus lisaaTilaus(Tilaus tilaus) {
        return tiRepository.save(tilaus);
    }

    public Tilaus paivitaTilaus(Long id, Tilaus tilaus) {
        Optional<Tilaus> optionalTilaus = tiRepository.findById(id);
        if (optionalTilaus.isPresent()) {
            tilaus.setTilaus_id(id);
            return tiRepository.save(tilaus);
        } else {
            return null;
        }
    }

    public boolean poistaTilaus(Long id) {
        Optional<Tilaus> optionalTilaus = tiRepository.findById(id);
        if (optionalTilaus.isPresent()) {
        	tiRepository.delete(optionalTilaus.get());
            return true;
        } else {
            return false;
        }
    }

}