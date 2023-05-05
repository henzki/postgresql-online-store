package com.henzki.postgresql.service;

import com.henzki.postgresql.model.Asiakas;
import com.henzki.postgresql.repo.AsiakasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsiakasService {

    private final AsiakasRepository asRepository;

    @Autowired
    public AsiakasService(AsiakasRepository asiakasRepository) {
        this.asRepository = asiakasRepository;
    }
    
    public List<Asiakas> haeKaikkiAsiakkaat() {
        return asRepository.findAll();
    }

    public Asiakas haeAsiakas(Long id) {
        Optional<Asiakas> optionalAsiakas = asRepository.findById(id);
        return optionalAsiakas.orElse(null);
    }

    public Asiakas lisaaAsiakas(Asiakas asiakas) {
        return asRepository.save(asiakas);
    }

    public Asiakas paivitaAsiakas(Long id, Asiakas asiakas) {
        Optional<Asiakas> optionalAsiakas = asRepository.findById(id);
        if (optionalAsiakas.isPresent()) {
            asiakas.setId(id);
            return asRepository.save(asiakas);
        } else {
            return null;
        }
    }

    public boolean poistaAsiakas(Long id) {
        Optional<Asiakas> optionalAsiakas = asRepository.findById(id);
        if (optionalAsiakas.isPresent()) {
        	asRepository.delete(optionalAsiakas.get());
            return true;
        } else {
            return false;
        }
    }

}

