package com.henzki.postgresql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzki.postgresql.model.Tilausrivi;
import com.henzki.postgresql.repo.TilausriviRepository;

@Service
public class TilausriviService {

    private final TilausriviRepository tiriRepository;

    @Autowired
    public TilausriviService(TilausriviRepository tilausriviRepository) {
        this.tiriRepository = tilausriviRepository;
    }
    
    public List<Tilausrivi> haeKaikkiTilausrivit() {
        return tiriRepository.findAll();
    }

    public Tilausrivi haeTilausrivi(Long id) {
        Optional<Tilausrivi> optionalTilausrivi = tiriRepository.findById(id);
        return optionalTilausrivi.orElse(null);
    }

    public Tilausrivi lisaaTilausrivi(Tilausrivi tilausrivi) {
        return tiriRepository.save(tilausrivi);
    }

    public Tilausrivi paivitaTilausrivi(Long id, Tilausrivi tilausrivi) {
        Optional<Tilausrivi> optionalTilausrivi = tiriRepository.findById(id);
        if (optionalTilausrivi.isPresent()) {
        	tilausrivi.setTilausrivi_id(id);
            return tiriRepository.save(tilausrivi);
        } else {
            return null;
        }
    }

    public boolean poistaTilausrivi(Long id) {
        Optional<Tilausrivi> optionalTilausrivi = tiriRepository.findById(id);
        if (optionalTilausrivi.isPresent()) {
        	tiriRepository.delete(optionalTilausrivi.get());
            return true;
        } else {
            return false;
        }
    }

}
