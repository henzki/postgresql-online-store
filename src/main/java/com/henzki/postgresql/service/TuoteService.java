package com.henzki.postgresql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.henzki.postgresql.dto.TuoteDTO;
import com.henzki.postgresql.mapper.AsiakasMapper;
import com.henzki.postgresql.mapper.TuoteMapper;
import com.henzki.postgresql.model.Asiakas;
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
    
    public List<TuoteDTO> haeKaikkiTuotteet() {
        List<Tuote> tuotteet = tuRepository.findAll();
        return tuotteet.stream()
                .map(TuoteMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public TuoteDTO haeTuote(Long id) {
        Optional<Tuote> optionalTilaus = tuRepository.findById(id);
        return optionalTilaus.map(TuoteMapper::mapToDTO).orElse(null);
    }

    public TuoteDTO lisaaTuote(TuoteDTO tuoteDTO) {
        Tuote tuote = TuoteMapper.mapToEntity(tuoteDTO);
        tuote = tuRepository.save(tuote);
        return TuoteMapper.mapToDTO(tuote);
    }

    public TuoteDTO paivitaTuote(Long id, TuoteDTO tuoteDTO) {
        Optional<Tuote> optionalTuote = tuRepository.findById(id);
        if (optionalTuote.isPresent()) {
            Tuote tuote = TuoteMapper.mapToEntity(tuoteDTO);
            tuote.setTuote_id(id);
            tuote = tuRepository.save(tuote);
            return TuoteMapper.mapToDTO(tuote);
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
