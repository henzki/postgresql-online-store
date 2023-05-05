package com.henzki.postgresql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzki.postgresql.model.Tuote;
import com.henzki.postgresql.repo.TuoteRepository;

@Service
public class TuoteService {

    private final TuoteRepository tuRepository;

    @Autowired
    public TuoteService(TuoteRepository tuoteRepository) {
        this.tuRepository = tuoteRepository;
    }
    
    public List<Tuote> haeKaikkiTuotteet() {
        return tuRepository.findAll();
    }

    public Tuote haeTuote(Long id) {
        Optional<Tuote> optionalTilaus = tuRepository.findById(id);
        return optionalTilaus.orElse(null);
    }

    public Tuote lisaaTuote(Tuote tuote) {
        return tuRepository.save(tuote);
    }

    public Tuote paivitaTuote(Long id, Tuote tuote) {
        Optional<Tuote> optionalTuote = tuRepository.findById(id);
        if (optionalTuote.isPresent()) {
        	tuote.setTuote_id(id);
            return tuRepository.save(tuote);
        } else {
            return null;
        }
    }

    public boolean poistaTuote(Long id) {
        Optional<Tuote> optionalTuote = tuRepository.findById(id);
        if (optionalTuote.isPresent()) {
        	tuRepository.delete(optionalTuote.get());
            return true;
        } else {
            return false;
        }
    }

}
