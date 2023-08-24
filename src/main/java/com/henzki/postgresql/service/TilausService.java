package com.henzki.postgresql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzki.postgresql.dto.TilausDTO;
import com.henzki.postgresql.mapper.TilausMapper;
import com.henzki.postgresql.model.Tilaus;
import com.henzki.postgresql.repo.TilausRepository;

@Service
public class TilausService {

    private final TilausRepository tiRepository;

    @Autowired
    public TilausService(TilausRepository tilausRepository) {
        this.tiRepository = tilausRepository;
    }
    
    public List<TilausDTO> haeKaikkiTilaukset() {
        List<Tilaus> tilaukset = tiRepository.findAll();
        return tilaukset.stream()
            .map(TilausMapper::mapToDTO)
            .collect(Collectors.toList());
    }

    public TilausDTO haeTilaus(Long id) {
        Optional<Tilaus> optionalTilaus = tiRepository.findById(id);
        return optionalTilaus.map(TilausMapper::mapToDTO).orElse(null);
    }

    public TilausDTO lisaaTilaus(TilausDTO tilausDTO) {
        Tilaus tilaus = TilausMapper.mapToEntity(tilausDTO);
        tilaus = tiRepository.save(tilaus);
        return TilausMapper.mapToDTO(tilaus);
    }

    public TilausDTO paivitaTilaus(Long id, TilausDTO tilausDTO) {
        Optional<Tilaus> optionalTilaus = tiRepository.findById(id);
        if (optionalTilaus.isPresent()) {
            Tilaus tilaus = TilausMapper.mapToEntity(tilausDTO);
            tilaus.setTilaus_id(id);
            tilaus = tiRepository.save(tilaus);
            return TilausMapper.mapToDTO(tilaus);
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
